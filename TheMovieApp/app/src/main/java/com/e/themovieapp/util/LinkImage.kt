package com.e.themovieapp.util

class LinkImage {

    companion object {
        private const val LINK_NOT_FOUND = "https://user-images.githubusercontent.com/24848110/33519396-7e56363c-d79d-11e7-969b-09782f5ccbab.png"
        private const val LINK = "https://image.tmdb.org/t/p/w500"
        fun find(path: String?) = if(path != null) "$LINK$path" else LINK_NOT_FOUND
    }

}