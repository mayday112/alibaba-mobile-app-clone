package com.example.utsecommerce.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.utsecommerce.Models.UserModel;
import com.example.utsecommerce.databinding.ActivityLoginBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void prosesLogin(View view){
        DatabaseReference ref = database.getReference("tb_user");

        String phone = binding.phone.getText().toString();
        String password = binding.password.getText().toString();

        if(!phone.isEmpty() && !password.isEmpty()){
            ref.child(phone).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        UserModel userFirebase = snapshot.getValue(UserModel.class);
                        if(userFirebase.getPassword().equals(password)){
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("user", userFirebase);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Masukkan Nomor telepon dan Password yang benar", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Pengguna tidak terdaftar", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }else {
            Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show();
        }
    }
}