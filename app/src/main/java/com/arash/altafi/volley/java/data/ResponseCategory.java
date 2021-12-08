package com.arash.altafi.volley.java.data;

import com.google.gson.annotations.SerializedName;

public class ResponseCategory {

	@SerializedName("image")
	private String image;

	@SerializedName("price")
	private int price;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	public String getImage(){
		return image;
	}

	public String getPrice(){
		return price+"";
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}
}