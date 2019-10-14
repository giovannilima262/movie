package com.e.themovieapp.enums

import com.e.themovieapp.R

enum class GenreEnum(val id: Int, val nameRString: Int) {
    ACTION(1, R.string.action),
    DRAMA(2, R.string.drama),
    FANTASY(3, R.string.fantasy),
    FICTION(4, R.string.fiction)
}