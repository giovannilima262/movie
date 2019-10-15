package com.e.themovieapp.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Movie(
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("overview")
    @Expose
    val description: String,
    @SerializedName("poster_path")
    @Expose
    val imageUrl: String
): Serializable