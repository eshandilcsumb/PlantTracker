package com.example.planttracker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planttracker.database.AppRepository;
import com.example.planttracker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // TODO: implement onClick for My Plants button

        // TODO: implement onClick for My Areas button

        // TODO: implement onClick for Admin Options button
    }

    // TODO: implement basic intent factory
}