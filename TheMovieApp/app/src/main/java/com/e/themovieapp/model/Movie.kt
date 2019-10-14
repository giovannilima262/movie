package com.e.themovieapp.model

import com.e.themovieapp.enums.GenreEnum
import java.io.Serializable

class Movie(val title: String, val genre: GenreEnum, val description: String, val imageUrl: String): Serializable