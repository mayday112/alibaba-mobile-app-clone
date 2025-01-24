package com.example.utsecommerce.Activities;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.utsecommerce.databinding.ActivityLoginBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {

    protected FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
//        Window w = getWindow();
//        w.setFlags(
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//                ,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS );
    }
}
