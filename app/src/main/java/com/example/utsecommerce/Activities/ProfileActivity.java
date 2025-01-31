package com.example.utsecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.utsecommerce.Models.UserModel;
import com.example.utsecommerce.R;
import com.example.utsecommerce.databinding.ActivityProfileBinding;

public class ProfileActivity extends BaseActivity {
    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        initVariabel();
    }

    private void initVariabel() {
        UserModel user =(UserModel) getIntent().getSerializableExtra("user");
        if(user == null) return;
        binding.nama.setText(user.getName());
        binding.email.setText(user.getEmail());
        binding.phone.setText(user.getPhone());
    }

    public void back(View view){
        finish();
    }


}