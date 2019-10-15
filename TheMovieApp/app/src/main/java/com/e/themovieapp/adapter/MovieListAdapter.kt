package com.e.themovieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.e.themovieapp.R
import com.e.themovieapp.retrofit.model.Movie
import kotlinx.android.synthetic.main.list_item_movie.view.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import android.content.Intent
import com.e.themovieapp.ui.main.activity.DescriptionActivity
import com.e.themovieapp.util.Extra.MOVIE
import com.e.themovieapp.util.LinkImage


class MovieListAdapter(private val movies: List<Movie>, private val context: Context): Adapter<MovieListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.title.text = movie.title
        Glide.with(context)
            .load(LinkImage.find(movie.imageUrl)).apply(RequestOptions())
            .into(holder.image)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DescriptionActivity::class.java)
            intent.putExtra(MOVIE.name, movie)
            context.startActivity(intent)
        }
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title = itemView.title!!
        val image = itemView.image!!
    }

}