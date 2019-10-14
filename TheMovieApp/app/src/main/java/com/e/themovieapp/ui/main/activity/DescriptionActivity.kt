package com.e.themovieapp.ui.main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.e.themovieapp.R
import com.e.themovieapp.model.Movie
import com.e.themovieapp.util.Extra.MOVIE
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        getMovie()
    }

    private fun getMovie() {
        val movie = intent.getSerializableExtra(MOVIE.name) as Movie
        title = movie.title
        description.text = movie.description
        Glide.with(this)
            .load(movie.imageUrl).apply(RequestOptions())
            .into(image)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
