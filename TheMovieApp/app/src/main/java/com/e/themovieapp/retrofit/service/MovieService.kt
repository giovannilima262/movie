package com.e.themovieapp.retrofit.service

import com.e.themovieapp.retrofit.model.RetrofitResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("discover/movie")
    fun movieByGenre(@Query("with_genres") genreId: Int, @Query("language") language: String, @Query("api_key") api_key: String): Call<RetrofitResult>

    @GET("search/movie")
    fun movieByTitle(@Query("query") title: String, @Query("language") language: String, @Query("api_key") api_key: String): Call<RetrofitResult>
}