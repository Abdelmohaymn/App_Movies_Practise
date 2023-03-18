package com.example.moviespractise.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviespractise.BaseAdapter
import com.example.moviespractise.MoviesAdapter
import com.example.moviespractise.model.State
import com.example.moviespractise.model.popularmovies.Movie

private const val baseImageMovieUrl = "http://image.tmdb.org/t/p/w500"


@BindingAdapter(value = ["showWhenLoading"])
fun<T> loading(view: View, state: State<T>?) {
    if(state is State.Loading){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}
@BindingAdapter(value = ["showWhenSuccess"])
fun<T> success(view: View, state: State<T>?) {
    if(state is State.Success){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}
@BindingAdapter(value = ["showWhenError"])
fun<T> error(view: View, state: State<T>?) {
    if(state is State.Error){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}
@BindingAdapter(value = ["imageUrl"])
fun imageFromUrl(view:ImageView,url:String){
    Glide.with(view).load(baseImageMovieUrl+url).centerCrop().into(view)
}
@BindingAdapter(value = ["adapterList"])
fun<T> setAdapterList(view:RecyclerView,items:List<T>?){
    if(items!=null){
        (view.adapter as BaseAdapter<T>?)?.setList(items)
    }else{
        (view.adapter as BaseAdapter<T>?)?.setList(emptyList())
    }
}