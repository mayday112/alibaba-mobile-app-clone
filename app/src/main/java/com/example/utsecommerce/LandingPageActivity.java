package com.example.utsecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LandingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
    }

    public  void toMain(View view){
        Intent intent = new Intent(LandingPageActivity.this, MainActivity.class);
        startActivity(intent);
    }
}