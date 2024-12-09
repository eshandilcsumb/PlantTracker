package com.example.planttracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planttracker.databinding.ActivityViewAreaBinding;

public class ViewAreaActivity extends AppCompatActivity {
    private ActivityViewAreaBinding binding;
    private int loggedInUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewAreaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get userID from shared preferences
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.sharedPreferencesFileName), Context.MODE_PRIVATE);
        loggedInUserID = sharedPreferences.getInt(getString(R.string.sharedPreferencesUserIDKey), MainActivity.LOGGED_OUT_USER_ID);

        binding.viewAreaActivityEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clicking the edit button will start the AreaActivity.
                startActivity(new Intent(ViewAreaActivity.this, EditAreaActivity.class));
            }
        });

        // implement onClick for Back button
        /** Commented out, implemented prior to the implementation of AreasActivityIntentFactory.
        binding.viewAreaActivityBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clicking the back button will send user back to AreasActivity.
                startActivity(AreasActivity.AreasActivityIntentFactory(getApplicationContext()));
            }
        });
        */
    }
    // Basic ViewAreaIntentFactory
    static Intent viewAreaActivityIntentFactory(Context context){
        return new Intent(context, ViewAreaActivity.class);
    }
}