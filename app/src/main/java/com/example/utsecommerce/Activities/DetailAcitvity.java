package com.example.utsecommerce.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.utsecommerce.Adapters.VarianAdapter;
import com.example.utsecommerce.Models.ItemModel;
import com.example.utsecommerce.R;
import com.example.utsecommerce.Utilities.RupiahFormatter;
import com.example.utsecommerce.databinding.ActivityDetailAcitvityBinding;

import java.util.ArrayList;

public class DetailAcitvity extends BaseActivity {

    ActivityDetailAcitvityBinding binding;
    private ItemModel item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailAcitvityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initItem();
        initVariabel();
        initVarian();
    }

    private void initVarian() {
        ArrayList<String> varian = item.getVarian();
        RecyclerView.Adapter adapter = new VarianAdapter(varian);

        binding.varianRecycleView.setAdapter(adapter);
        binding.varianRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void initVariabel() {
        binding.titleItem.setText(item.getNama());
        binding.hargaItem.setText(RupiahFormatter.formatRupiah(Double.parseDouble(item.getHarga())));
        binding.deksripsiItem.setText(item.getDeskripsi());
        binding.minPesanTxt.setText("minimal pemesanan: "+ item.getMinPesan()+" buah");
        binding.photoItem.setImageResource(Integer.parseInt(item.getPhotoPath()));
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void initItem() {
        this.item = (ItemModel) getIntent().getSerializableExtra("item");
    }
}