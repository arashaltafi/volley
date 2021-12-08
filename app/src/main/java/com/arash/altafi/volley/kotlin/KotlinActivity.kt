package com.arash.altafi.volley.kotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.arash.altafi.volley.R
import com.arash.altafi.volley.java.adapter.CategoryAdapter
import com.arash.altafi.volley.java.adapter.NewsAdapter
import com.arash.altafi.volley.java.api.ApiService
import com.arash.altafi.volley.kotlin.utils.CenterZoomLayoutManager
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : AppCompatActivity() {

    private var apiService: ApiService? = null
    private var newsAdapter: NewsAdapter? = null
    private var categoryAdapter: CategoryAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        apiService = ApiService(this)
        init()
    }

    private fun init() {
        getNews()
        getCategory()
    }

    private fun getNews() {
        apiService!!.get_News({ response ->
            newsAdapter = NewsAdapter(response, this)
            // Set Select Item
            val snapHelper: SnapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(recy_news_kotlin)
            // Set Effect
            val centerZoomLayoutManager = CenterZoomLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
            recy_news_kotlin.layoutManager = centerZoomLayoutManager
            // Set Adapter
            recy_news_kotlin.adapter = newsAdapter
            // Set When Layer in NestedScroll
            recy_news_kotlin.isNestedScrollingEnabled = false
            //recy_news_kotlin.setLayoutManager(new LinearLayoutManager(getApplicationContext() , RecyclerView.HORIZONTAL , false));
        }) {
                error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getCategory() {
        apiService!!.category(1, { response ->
            categoryAdapter = CategoryAdapter(response, this)
            recy_categories_kotlin.adapter = categoryAdapter
            recy_categories_kotlin.layoutManager = GridLayoutManager(applicationContext, 2)
            recy_categories_kotlin.isNestedScrollingEnabled = false
        })
        {
            Toast.makeText(this , "خطا در اتصال", Toast.LENGTH_SHORT).show()
        }
    }

}