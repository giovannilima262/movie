package com.e.themovieapp.ui.main.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.e.themovieapp.R
import com.e.themovieapp.adapter.MovieListAdapter
import com.e.themovieapp.presenter.MoviePresenter
import com.e.themovieapp.retrofit.MovieResponse
import com.e.themovieapp.retrofit.model.Movie
import kotlinx.android.synthetic.main.activity_search_results.*

class SearchResultsActivity : AppCompatActivity() {

    private var moviesList: MutableList<Movie> = mutableListOf()
    var contextActivity = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)
        backButton()
        cleanInput()
        recycleViewScreen()
        searchMovieByName()
    }

    private fun recycleViewScreen() {
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recycleViewScreen.layoutManager = layoutManager
    }

    private fun searchMovieByName() {

        input_text.setOnEditorActionListener { v, actionId, _ ->
            if(actionId == EditorInfo.IME_ACTION_DONE){
                MoviePresenter().findByTitle(v.text.toString(),
                    object : MovieResponse {
                        override fun success(movies: List<Movie>) {
                            if(moviesList.isEmpty()) {
                                moviesList = movies.toMutableList()
                                recycleViewScreen.adapter = MovieListAdapter(moviesList, contextActivity)
                            }else {
                                moviesList.clear()
                                moviesList.addAll(movies)
                                recycleViewScreen.adapter?.notifyDataSetChanged()
                            }
                            keyboardScreen()
                        }
                    })
                true
            }else {
                false
            }
        }


    }

    private fun keyboardScreen() {
        input_text.clearFocus()
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(input_text.windowToken, 0)
    }

    private fun backButton() {
        back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun cleanInput() {
        clean.setOnClickListener {
            input_text.text.clear()
            moviesList.clear()
            recycleViewScreen.adapter?.notifyDataSetChanged()
        }
    }


}
