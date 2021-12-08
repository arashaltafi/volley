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
import com.arash.altafi.volley.java.data.ResponseNews;
import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    List<ResponseNews> responseNews = new ArrayList<>();
    Context context;

    public NewsAdapter(List<ResponseNews> responseNews, Context context) {
        this.responseNews = responseNews;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        ResponseNews news = responseNews.get(position);
        holder.txtTitle.setText(news.getTitle());
        holder.txtContent.setText(news.getContent());
        holder.txtAuthor.setText(news.getName());
        holder.txtDate.setText(news.getDate());
        Glide.with(context).load(news.getImage()).into(holder.imgNews);
        Glide.with(context).load(news.getWriterImage()).into(holder.imgAuthor);
    }

    @Override
    public int getItemCount() {
        return responseNews.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        private TextView txtContent,txtTitle,txtAuthor,txtDate;
        private CircleImageView imgAuthor;
        private ImageView imgNews;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDate = itemView.findViewById(R.id.txt_date_news);
            txtAuthor = itemView.findViewById(R.id.txt_author_news);
            txtContent = itemView.findViewById(R.id.txt_content_news);
            txtTitle = itemView.findViewById(R.id.txt_title_news);
            imgAuthor = itemView.findViewById(R.id.img_author_news);
            imgNews = itemView.findViewById(R.id.img_news);
        }
    }

}
