package com.example.utsecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.utsecommerce.databinding.ActivityDetailAcitvityBinding;

public class DetailAcitvity extends AppCompatActivity {

    ActivityDetailAcitvityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailAcitvityBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_detail_acitvity);
    }
}