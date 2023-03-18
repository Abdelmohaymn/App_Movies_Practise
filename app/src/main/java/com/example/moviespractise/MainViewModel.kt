package com.example.moviespractise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

class MainViewModel:ViewModel(),MoviesAdapter.ItemsInteraction {
    private val repository=MoviesRepository()
    val popularMovies = repository.getPopularMovies().asLiveData()
    override fun onClickOnItem() {
        TODO("Not yet implemented")
    }
}