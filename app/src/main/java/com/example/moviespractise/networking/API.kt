package com.example.moviespractise.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private const val BASE_URL="https://api.themoviedb.org/3/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
        //.addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
    val apiService: MovieService = retrofit.create(MovieService::class.java)
}