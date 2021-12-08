package com.arash.altafi.volley.java.api;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.arash.altafi.volley.java.data.ResponseCategory;
import com.arash.altafi.volley.java.data.ResponseNews;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiService {

    private final RequestQueue requestQueue;
    private final Map<String,String> map = new HashMap<String,String>();

    public ApiService(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public void get_News(Response.Listener<List<ResponseNews>> listListener, Response.ErrorListener errorListener) {
        GsonRequest<List<ResponseNews>> request = new GsonRequest<>(Request.Method.GET,"home/home_news.php",
                new TypeToken<List<ResponseNews>>(){}.getType(),listListener,errorListener);
        requestQueue.add(request);
    }

    public void category(int category, Response.Listener<List<ResponseCategory>> listListener, Response.ErrorListener errorListener) {
        GsonRequest<List<ResponseCategory>> request = new GsonRequest<>(Request.Method.POST,"products/category_products.php",
                new TypeToken<List<ResponseCategory>>(){}.getType(),listListener,errorListener);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("cat_id",category);
        request.setJsonObject(jsonObject);
        requestQueue.add(request);
    }

//    public void getDetailsNews(int id, String header, Response.Listener<ResponseDetailsNews> listener, Response.ErrorListener errorListener) {
//        GsonRequest<ResponseDetailsNews> request = new GsonRequest<>(Request.Method.POST,"news/news.php",
//                new TypeToken<ResponseDetailsNews>(){}.getType(),listener,errorListener);
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("id",id);
//        map.put("Authorization",header);
//        request.setMap(map);
//        request.setJsonObject(jsonObject);
//        requestQueue.add(request);
//
//    }
//    public void send_comment(int id , String content , String header , Response.Listener<ResponseMessageComment> listener, Response.ErrorListener errorListener) {
//        GsonRequest<ResponseMessageComment> request = new GsonRequest<>(Request.Method.POST,"news/get_comment.php",
//                new TypeToken<ResponseMessageComment>(){}.getType(),listener,errorListener);
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("news_id",id);
//        jsonObject.addProperty("content",content);
//        map.put("Authorization",header);
//        request.setMap(map);
//        request.setJsonObject(jsonObject);
//        requestQueue.add(request);
//    }
//
//    public void get_Profile (String header , Response.Listener<ResponseProfile> listener, Response.ErrorListener errorListener) {
//        GsonRequest<ResponseProfile> request = new GsonRequest<>(Request.Method.POST,"profile/show_profile.php",
//                new TypeToken<ResponseProfile>(){}.getType(),listener,errorListener);
//        map.put("Authorization",header);
//        request.setMap(map);
//        requestQueue.add(request);
//    }

}

// More Sample in CoffeBazaar Project => GitHub