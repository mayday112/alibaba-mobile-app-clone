package com.example.utsecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.utsecommerce.R;
import com.example.utsecommerce.databinding.ActivityProfileBinding;

public class ProfileActivity extends BaseActivity {
    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    }

    public void back(View view){
        finish();
    }
}