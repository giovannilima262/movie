package com.e.themovieapp.presenter

import com.e.themovieapp.enums.GenreEnum
import com.e.themovieapp.model.Movie

interface IMoviePresenter {

    fun findByGenre(genre: GenreEnum): List<Movie>

    fun findByTitle(title: String): List<Movie>

    fun findAll(): List<Movie>

}