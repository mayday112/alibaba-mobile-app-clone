package com.example.utsecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.utsecommerce.R;

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView imageView = findViewById(R.id.imageView);

        // Animasi fade in dengan durasi 2 detik
        ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f);
        fadeAnim.setDuration(2000);
        fadeAnim.start();

        // Setelah animasi selesai, pindah ke activity utama
        fadeAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent intent = new Intent(SplashScreenActivity.this, SplashScreen2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}