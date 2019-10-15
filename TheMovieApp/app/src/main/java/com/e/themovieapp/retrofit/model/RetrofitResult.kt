package com.e.themovieapp.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RetrofitResult (
    @SerializedName("results")
    @Expose
    val movies: List<Movie>
): Serializable