package com.example.planttracker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planttracker.databinding.ActivityEditPlantBinding;

public class EditPlantActivity extends AppCompatActivity {
    private ActivityEditPlantBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditPlantBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // TODO: implement onClick for Save button

        // TODO: implement onClick for Cancel button

        // TODO: implement onClick for Delete button
    }

    // TODO: implement basic intent factory
}