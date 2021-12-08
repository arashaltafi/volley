package com.arash.altafi.volley.kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.volley.R
import com.arash.altafi.volley.kotlin.data.ResponseCategoryKotlin
import com.bumptech.glide.Glide

class CategoryAdapterKotlin(private val categoriesList : List<ResponseCategoryKotlin>) : RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_category , parent , false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val list = categoriesList[position]
        holder.txtTitle.text = list.title
        holder.txtPrice.text = list.price.toString()
        Glide.with(holder.itemView.context).load(list.image).into(holder.imgProduct)
    }

    override fun getItemCount(): Int = categoriesList.size

}

class CategoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val txtTitle : TextView = itemView.findViewById(R.id.txt_title_product)
    var txtPrice :TextView = itemView.findViewById(R.id.txt_price_product)
    val imgProduct : ImageView = itemView.findViewById(R.id.img_product)

}