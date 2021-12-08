package com.arash.altafi.volley.kotlin.api

import com.android.volley.*
import com.android.volley.toolbox.HttpHeaderParser
import com.google.gson.Gson
import com.google.gson.JsonObject
import java.lang.reflect.Type

class GsonRequest<T>(method: Int, url: String, private val type: Type, listener: Response.Listener<*>, errorListener: Response.ErrorListener?) : Request<T>(method, "https://arashaltafi.ir/caffebazaar/v1/$url", errorListener) {
    private val listener: Response.Listener<T> = listener as Response.Listener<T>
    private var jsonObject: JsonObject? = null
    private var map: Map<String, String>? = null

    override fun parseNetworkResponse(response: NetworkResponse): Response<T> {
        return try {
            val json = String(response.data)
            val gson = Gson()
            val result: T = gson.fromJson(json, type)
            Response.success(result, HttpHeaderParser.parseCacheHeaders(response))
        } catch (e: Exception) {
            Response.error(VolleyError())
        }
    }

    override fun deliverResponse(response: T) {
        listener.onResponse(response)
    }

    fun setJsonObject(jsonObject: JsonObject?) {
        this.jsonObject = jsonObject
    }

    override fun getHeaders(): Map<String, String> {
        return if (map != null) map!! else super.getHeaders()
    }

    fun setMap(map: Map<String, String>?) {
        this.map = map
    }

    override fun getBody(): ByteArray {
        return if (jsonObject != null) {
            jsonObject.toString().toByteArray()
        } else super.getBody()
    }

}
