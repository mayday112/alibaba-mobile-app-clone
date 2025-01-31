package com.example.utsecommerce.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.utsecommerce.Models.UserModel;
import com.example.utsecommerce.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends BaseActivity {
    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.daftarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerProses(view);
            }
        });
    }

    public void registerProses(View view){
        DatabaseReference ref = database.getReference("tb_user");

        String nama = binding.nama.getText().toString();
        String email = binding.email.getText().toString();
        String phone = binding.phone.getText().toString();
        String password = binding.password.getText().toString();
        String konfirmasiPassword = binding.confirmPass.getText().toString();

        if(!nama.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !password.isEmpty() && !konfirmasiPassword.isEmpty()){
            Toast.makeText(this,nama+email+password+phone+konfirmasiPassword,Toast.LENGTH_SHORT).show();
            if(password.equals(konfirmasiPassword)){
                ref.child(phone).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(!snapshot.exists()){
                            UserModel user = new UserModel(nama, phone, email, password);
                            ref.child(phone).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(RegisterActivity.this, "Silakan Login", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        } else {
                            Toast.makeText(RegisterActivity.this, "Nomor sudah terdaftar", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }else {
                Toast.makeText(this, "Password tidak sama", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Harap isi semual kolom", Toast.LENGTH_SHORT).show();
        }
    }

//    private void createUserFirebase(UserModel user){
//                        ref.child(phone).setValue(user).ad
//    }
}