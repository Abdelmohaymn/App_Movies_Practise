package com.example.moviespractise

import com.example.moviespractise.model.State
import com.example.moviespractise.networking.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MoviesRepository {

    private val API_KEY:String = "a191cbd6c4b9205d50a644818a12e947"

    fun getPopularMovies()=wrapWithFlow { API.apiService.getPopularMovies(API_KEY) }

    private fun<T> wrapWithFlow(function:suspend ()->Response<T>):Flow<State<T>>{
        return flow {
            emit(State.Loading)
            try {
                val res = function()
                if (res.isSuccessful){
                    emit(State.Success(res.body()))
                }else{
                    emit(State.Error(res.message()))
                }
            }catch (e:Exception){
                emit(State.Error(e.message.toString()))
            }
        }
    }
}