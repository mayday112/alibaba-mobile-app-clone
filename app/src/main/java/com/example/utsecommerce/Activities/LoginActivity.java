package com.example.utsecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.utsecommerce.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}