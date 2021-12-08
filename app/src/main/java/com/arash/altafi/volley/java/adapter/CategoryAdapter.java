package com.arash.altafi.volley.java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arash.altafi.volley.R;
import com.arash.altafi.volley.java.data.ResponseCategory;
import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    List<ResponseCategory> responseCategories;
    Context context;

    public CategoryAdapter(List<ResponseCategory> responseCategories, Context context) {
        this.responseCategories = responseCategories;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        ResponseCategory category = responseCategories.get(position);
        holder.txt_title.setText(category.getTitle());
        holder.txt_price.setText(category.getPrice());
        Glide.with(context).load(category.getImage()).into(holder.img_product);
    }

    @Override
    public int getItemCount() {
        return responseCategories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_title,txt_price;
        private ImageView img_product;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_price = itemView.findViewById(R.id.txt_price_product);
            txt_title = itemView.findViewById(R.id.txt_title_product);
            img_product = itemView.findViewById(R.id.img_product);
        }
    }

}
