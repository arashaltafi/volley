package com.arash.altafi.volley.kotlin.api

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.arash.altafi.volley.java.api.GsonRequest
import com.arash.altafi.volley.java.data.*
import com.arash.altafi.volley.kotlin.data.ResponseCategoryKotlin
import com.arash.altafi.volley.kotlin.data.ResponseNewsKotlin
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import java.util.*

class ApiService(context: Context?) {

    private val requestQueue: RequestQueue = Volley.newRequestQueue(context)
    private val map: MutableMap<String, String> = HashMap()

    fun getNews(listListener: Response.Listener<List<ResponseNewsKotlin>>, errorListener: Response.ErrorListener) {
        val request = GsonRequest<List<ResponseNews>>(Request.Method.GET, "home/home_news.php", object : TypeToken<List<ResponseNews>>() {}.type, listListener, errorListener)
        requestQueue.add(request)
    }

    fun category(category: Int, listListener: Response.Listener<List<ResponseCategoryKotlin>>, errorListener: Response.ErrorListener) {
        val request = GsonRequest<List<ResponseCategory>>(Request.Method.POST, "products/category_products.php", object : TypeToken<List<ResponseCategory>>() {}.type, listListener, errorListener)
        val jsonObject = JsonObject()
        jsonObject.addProperty("cat_id", category)
        request.setJsonObject(jsonObject)
        requestQueue.add(request)
    }

//    fun getDetailsNews(id: Int, header: String, listener: Response.Listener<ResponseDetailsNews>, errorListener: Response.ErrorListener) {
//        val request = GsonRequest<ResponseDetailsNews>(Request.Method.POST, "news/news.php", object : TypeToken<ResponseDetailsNews>() {}.type, listener, errorListener)
//        val jsonObject = JsonObject()
//        jsonObject.addProperty("id", id)
//        map["Authorization"] = header
//        request.setMap(map)
//        request.setJsonObject(jsonObject)
//        requestQueue.add(request)
//    }
//
//    fun sendComment(id: Int, content: String, header: String, listener: Response.Listener<ResponseMessageComment>, errorListener: Response.ErrorListener) {
//        val request = GsonRequest<ResponseMessageComment>(Request.Method.POST, "news/get_comment.php", object : TypeToken<ResponseMessageComment>() {}.type, listener, errorListener)
//        val jsonObject = JsonObject()
//        jsonObject.addProperty("news_id", id)
//        jsonObject.addProperty("content", content)
//        map["Authorization"] = header
//        request.setMap(map)
//        request.setJsonObject(jsonObject)
//        requestQueue.add(request)
//    }
//
//    fun getComment(id: Int, listListener: Response.Listener<List<ResponseComment>>, errorListener: Response.ErrorListener) {
//        val request = GsonRequest<List<ResponseComment>>(Request.Method.POST, "news/show_comments.php", object : TypeToken<List<ResponseComment>>() {}.type, listListener, errorListener)
//        val jsonObject = JsonObject()
//        jsonObject.addProperty("news_id", id)
//        request.setJsonObject(jsonObject)
//        requestQueue.add(request)
//    }
//
//    fun getProfile(header: String, listener: Response.Listener<ResponseProfile>, errorListener: Response.ErrorListener) {
//        val request = GsonRequest<ResponseProfile>(Request.Method.POST, "profile/show_profile.php", object : TypeToken<ResponseProfile>() {}.type, listener, errorListener)
//        map["Authorization"] = header
//        request.setMap(map)
//        requestQueue.add(request)
//    }

}