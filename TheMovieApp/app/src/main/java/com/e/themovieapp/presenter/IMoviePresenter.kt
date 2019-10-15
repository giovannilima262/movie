package com.e.themovieapp.presenter

import com.e.themovieapp.enums.GenreEnum
import com.e.themovieapp.retrofit.MovieResponse

interface IMoviePresenter {

    fun findByGenre(genre: GenreEnum, movieResponse: MovieResponse)

    fun findByTitle(title: String, movieResponse: MovieResponse)

}