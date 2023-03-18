package com.example.moviespractise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviespractise.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val viewModel:MainViewModel by viewModels()
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner=this
        binding.viewModel=viewModel

        val adapter = MoviesAdapter(mutableListOf(),viewModel)
        binding.myRecycler.adapter=adapter
    }
}