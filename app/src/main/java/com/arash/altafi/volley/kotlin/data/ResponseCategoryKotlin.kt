package com.arash.altafi.volley.kotlin.data

import com.google.gson.annotations.SerializedName

data class ResponseCategoryKotlin(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
)
