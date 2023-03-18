package com.example.moviespractise

import com.example.moviespractise.model.popularmovies.Movie

class MoviesAdapter(items:List<Movie>,myListener:ItemsInteraction):BaseAdapter<Movie>(items,myListener) {
    override val layoutId: Int = R.layout.movie_item

    interface ItemsInteraction : BaseItemsInteraction{
        fun onClickOnItem()
    }

}

