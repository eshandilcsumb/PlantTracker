package com.example.planttracker.database;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.planttracker.MainActivity;
import com.example.planttracker.database.entities.Area;
import com.example.planttracker.database.entities.Plant;
import com.example.planttracker.database.entities.User;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppRepository {
    private final AreaDAO areaDAO;
    private final PlantDAO plantDAO;
    private final UserDAO userDAO;
    private static AppRepository repository;

    private AppRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        this.areaDAO = db.areaDAO();
        this.plantDAO = db.plantDAO();
        this.userDAO = db.userDAO();
    }

    public static AppRepository getRepository(Application application) {
        if (repository != null) {
            return repository;
        }
        Future<AppRepository> future = AppDatabase.databaseWriteExecutor.submit(
                new Callable<AppRepository>() {
                    @Override
                    public AppRepository call() throws Exception {
                        return new AppRepository(application);
                    }
                }
        );
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.d(MainActivity.LOG_TAG, e.getMessage());
        }
        return null;
    }

    // Area methods
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void insertArea(Area... area) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            areaDAO.insert(area);
        });
    }

    public void deleteArea(Area area) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            areaDAO.delete(area);
        });
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Plant methods
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void insertPlant(Plant... plant) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            plantDAO.insert(plant);
        });
    }

    public void deletePlant(Plant plant) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            plantDAO.delete(plant);
        });
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // User methods
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void insertUser(User... user) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDAO.insert(user);
        });
    }

    public void deleteUser(User user) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDAO.delete(user);
        });
    }

    public LiveData<User> getUserByUsername(String username) {
        return userDAO.getUserByUserName(username);
    }

    public LiveData<User> getUserByUserID(int userID) {
        return userDAO.getUserByUserId(userID);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
}
