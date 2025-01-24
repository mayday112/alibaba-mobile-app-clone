package com.example.utsecommerce.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utsecommerce.databinding.ViewholderVarianBinding;

import java.util.ArrayList;

public class VarianAdapter extends RecyclerView.Adapter<VarianAdapter.ViewHolder> {
    ArrayList<String> items;
    Context context;

    public VarianAdapter() {
    }

    public VarianAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public VarianAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderVarianBinding binding = ViewholderVarianBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VarianAdapter.ViewHolder holder, int position) {
        String item = items.get(position);
        holder.binding.varianTxt.setText(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewholderVarianBinding binding;
        public ViewHolder(@NonNull ViewholderVarianBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
