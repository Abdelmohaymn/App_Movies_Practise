package com.example.moviespractise.networking

import com.example.moviespractise.model.movie.MoviesResponse
import com.example.moviespractise.model.popularmovies.PopularMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/{movie-id}")
    suspend fun getMovieInfo(
        @Path("movie-id") movieId:Int,
        @Query("api_key") apiKey:String,
        @Query("language") language:String?,
        @Query("append_to_response") appenedToResponse:String?
    ):Response<MoviesResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey:String,
    ):Response<PopularMoviesResponse>
}