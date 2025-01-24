package com.example.utsecommerce.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utsecommerce.Activities.DetailAcitvity;
import com.example.utsecommerce.Models.ItemModel;
import com.example.utsecommerce.R;
import com.example.utsecommerce.Utilities.RupiahFormatter;
import com.example.utsecommerce.databinding.ViewholderItemBinding;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private ArrayList<ItemModel> items;
    private Context context;

    public ItemAdapter(ArrayList<ItemModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderItemBinding binding = ViewholderItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        ItemModel item = items.get(position);

        holder.binding.itemTitle.setText(item.getNama());
        holder.binding.itemHarga.setText(RupiahFormatter.formatRupiah(Double.parseDouble(item.getHarga())));

        String photoPath = item.getPhotoPath();
        if(!photoPath.isEmpty() && photoPath != null){
            int res = Integer.parseInt(item.getPhotoPath());
            holder.binding.itemPic.setImageResource(res);
        } else {
            holder.binding.itemPic.setImageResource(R.drawable.celana_jeans);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailAcitvity.class);
                intent.putExtra("item", items.get(position));
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ViewholderItemBinding binding;

        public ViewHolder(@NonNull ViewholderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
