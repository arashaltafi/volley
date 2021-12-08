package com.arash.altafi.volley.kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.volley.R
import com.arash.altafi.volley.kotlin.data.ResponseNewsKotlin
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class NewsAdapter(private val newsList : List<ResponseNewsKotlin>) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_category , parent , false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val list = newsList[position]
        holder.txtTitle.text = list.title
        holder.txtContent.text = list.content
        holder.txtAuthor.text = list.name
        holder.txtDate.text = list.date
        Glide.with(holder.itemView.context).load(list.image).into(holder.imgNews)
        Glide.with(holder.itemView.context).load(list.writerImage).into(holder.imgAuthor)
    }

    override fun getItemCount(): Int = newsList.size

}

class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    var txtContent : TextView = itemView.findViewById(R.id.txt_content_news)
    var txtTitle :TextView = itemView.findViewById(R.id.txt_title_news)
    var txtAuthor :TextView = itemView.findViewById(R.id.txt_author_news)
    var txtDate :TextView = itemView.findViewById(R.id.txt_date_news)
    val imgAuthor : CircleImageView = itemView.findViewById(R.id.img_author_news)
    val imgNews: ImageView = itemView.findViewById(R.id.img_news)

}