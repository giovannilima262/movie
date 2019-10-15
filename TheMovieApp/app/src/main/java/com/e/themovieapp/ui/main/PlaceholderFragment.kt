package com.e.themovieapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.e.themovieapp.R
import com.e.themovieapp.adapter.MovieListAdapter
import com.e.themovieapp.enums.GenreEnum
import com.e.themovieapp.retrofit.model.Movie
import com.e.themovieapp.presenter.MoviePresenter
import com.e.themovieapp.retrofit.MovieResponse
import kotlinx.android.synthetic.main.fragment_main.view.*

class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_main, container, false)
        recycleViewScreen(root)
        return root
    }

    private fun recycleViewScreen(root: View?) {
        val recyclerView = (root?.listMovie as RecyclerView)
        findMoviesByGenre(root, recyclerView)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

    }

    private fun findMoviesByGenre(root: View?, recyclerView: RecyclerView) {
        MoviePresenter().findByGenre(GenreEnum.values()[(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1) - 1],
            object : MovieResponse {
                override fun success(movies: List<Movie>) {
                    recyclerView.adapter = MovieListAdapter(movies, root!!.context)
                }
        })
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}