package com.e.themovieapp.presenter

import android.util.Log
import com.e.themovieapp.enums.GenreEnum
import com.e.themovieapp.retrofit.model.Movie
import com.e.themovieapp.retrofit.MovieResponse
import com.e.themovieapp.retrofit.RetrofitInitializer
import com.e.themovieapp.retrofit.model.RetrofitResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter: IMoviePresenter {

    override fun findByGenre(genre: GenreEnum, movieResponse: MovieResponse) {
        val call = RetrofitInitializer().movieService().movieByGenre(genre.id, RetrofitInitializer.KEY)
        call.enqueue(object: Callback<RetrofitResult?> {
            override fun onResponse(call: Call<RetrofitResult?>?,
                                    response: Response<RetrofitResult?>?) {
                response?.body()?.let {
                    val result: RetrofitResult = it
                    movieResponse.success(result.movies)
                }
            }

            override fun onFailure(call: Call<RetrofitResult?>?,
                                   t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

    override fun findByTitle(title: String, movieResponse: MovieResponse) {
        val call = RetrofitInitializer().movieService().movieByTitle(title, RetrofitInitializer.KEY)
        call.enqueue(object: Callback<RetrofitResult?> {
            override fun onResponse(call: Call<RetrofitResult?>?,
                                    response: Response<RetrofitResult?>?) {
                response?.body()?.let {
                    val result: RetrofitResult = it
                    movieResponse.success(result.movies)
                }
            }

            override fun onFailure(call: Call<RetrofitResult?>?,
                                   t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        }) //To change body of created functions use File | Settings | File Templates.
    }



}