package com.e.themovieapp.enums

import com.e.themovieapp.R

// TODO o id corresponde ao id da API do The Movie DB
enum class GenreEnum(val id: Int, val nameRString: Int) {
    ACTION(28, R.string.action),
    DRAMA(18, R.string.drama),
    FANTASY(14, R.string.fantasy),
    FICTION(878, R.string.fiction)
}