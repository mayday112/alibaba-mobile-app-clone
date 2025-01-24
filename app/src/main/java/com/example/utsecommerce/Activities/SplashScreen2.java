package com.example.utsecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.utsecommerce.R;

public class SplashScreen2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        // Timer untuk splash screen
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen2.this, LandingPageActivity.class);
            startActivity(intent);
            finish();
        }, 2000); // Durasi splash screen (2000ms = 2 detik)
    }
}