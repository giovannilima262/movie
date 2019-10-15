package com.e.themovieapp.retrofit

import com.e.themovieapp.retrofit.service.MovieService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    companion object {
        const val KEY = "f60e5007e3d01d8128081ff55491d77b"
        const val LANGUAGE = "pt-BR"
    }


    private val urlString = "https://api.themoviedb.org/3/"

    private val retrofit = Retrofit.Builder()
            .baseUrl(urlString)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun movieService(): MovieService {
        return retrofit.create(MovieService::class.java)
    }

}