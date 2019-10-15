package com.e.themovieapp.retrofit

import com.e.themovieapp.retrofit.model.Movie

interface MovieResponse {

    fun success(movies: List<Movie>)

}