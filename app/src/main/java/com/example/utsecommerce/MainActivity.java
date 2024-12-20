package com.example.utsecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.utsecommerce.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

//public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadFragment(new BerandaFragment());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            int id = item.getItemId();

            if (id == R.id.beranda) {
                fragment = new BerandaFragment();
            } else if (id == R.id.troli) {
                fragment = new KeranjangFragment();
            }

            return loadFragment(fragment);
        });
//        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
//        navigationView.setOnItemSelectedListener(this);
    }


//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        Fragment fragment = null;
//        int id = item.getItemId();
//
//        if(id == R.id.beranda){
//            fragment = new BerandaFragment();
//        } else if(id == R.id.troli){
//            fragment = new KeranjangFragment();
//        }
//
//        return loadFragment(fragment);
//    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
        }
        return false;
    }


    public void toDetail(View view) {
        Intent intent = new Intent(MainActivity.this, DetailAcitvity.class);
        startActivity(intent);
    }
}