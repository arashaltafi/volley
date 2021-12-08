package com.arash.altafi.volley.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.arash.altafi.volley.R;
import com.arash.altafi.volley.java.adapter.CategoryAdapter;
import com.arash.altafi.volley.java.adapter.NewsAdapter;
import com.arash.altafi.volley.java.api.ApiService;
import com.arash.altafi.volley.java.data.ResponseCategory;
import com.arash.altafi.volley.java.data.ResponseNews;
import com.arash.altafi.volley.kotlin.utils.CenterZoomLayoutManager;

import java.util.List;

public class JavaActivity extends AppCompatActivity {

    private RecyclerView rcNews;
    private RecyclerView rcCats;
    private ApiService apiService;
    private NewsAdapter newsAdapter;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        apiService = new ApiService(this);
        init();
    }

    private void init() {
        findView();
        getNews();
        getCategory();
    }

    private void getNews() {
        apiService.get_News(new Response.Listener<List<ResponseNews>>() {
            @Override
            public void onResponse(List<ResponseNews> response) {
                newsAdapter = new NewsAdapter(response , JavaActivity.this);
                // Set Select Item
                SnapHelper snapHelper = new PagerSnapHelper();
                snapHelper.attachToRecyclerView(rcNews);
                // Set Effect
                CenterZoomLayoutManager centerZoomLayoutManager = new CenterZoomLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
                rcNews.setLayoutManager(centerZoomLayoutManager);
                // Set Adapter
                rcNews.setAdapter(newsAdapter);
                // Set When Layer in NestedScroll
                rcNews.setNestedScrollingEnabled(false);

                //rcNews.setLayoutManager(new LinearLayoutManager(getApplicationContext() , RecyclerView.HORIZONTAL , false));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(JavaActivity.this , error.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getCategory()
    {
        apiService.category(1, new Response.Listener<List<ResponseCategory>>() {
            @Override
            public void onResponse(List<ResponseCategory> response) {
                categoryAdapter = new CategoryAdapter(response,JavaActivity.this);
                rcCats.setAdapter(categoryAdapter);
                rcCats.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                rcCats.setNestedScrollingEnabled(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(JavaActivity.this, "خطا در اتصال" , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void findView() {
        rcNews = findViewById(R.id.recy_news);
        rcCats = findViewById(R.id.recy_categories);
    }

}