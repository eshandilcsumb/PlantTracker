package com.example.planttracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planttracker.databinding.ActivityViewPlantBinding;

public class ViewPlantActivity extends AppCompatActivity {
    private ActivityViewPlantBinding binding;
    private int loggedInUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewPlantBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get userID from shared preferences
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.sharedPreferencesFileName), Context.MODE_PRIVATE);
        loggedInUserID = sharedPreferences.getInt(getString(R.string.sharedPreferencesUserIDKey), MainActivity.LOGGED_OUT_USER_ID);

        // TODO: implement onClick for Water Plant button

        // TODO: implement onClick for Edit button

        // implement onClick for Back button
        binding.viewPlantActivityBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(PlantsActivity.plantsActivityIntentFactory(getApplicationContext()));
            }
        });
    }

    // implement basic intent factory
    static Intent viewPlantActivityIntentFactory(Context context){
        return new Intent(context, ViewPlantActivity.class);
    }

}