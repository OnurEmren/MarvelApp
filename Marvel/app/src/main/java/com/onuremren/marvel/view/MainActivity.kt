package com.onuremren.marvel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.onuremren.marvel.R
import com.onuremren.marvel.adapter.MarvelAdapter
import com.onuremren.marvel.databinding.ActivityMainBinding
import com.onuremren.marvel.databinding.FragmentListBinding
import com.onuremren.marvel.repo.Repository
import com.onuremren.marvel.service.Marvelnterface
import com.onuremren.marvel.viewmodel.MarvelViewModel
import com.onuremren.marvel.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    private val retrofitService = Marvelnterface.getInstance()
    lateinit var viewModel: MarvelViewModel
    private lateinit var dataBinding: ActivityMainBinding
    val adapter = MarvelAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)

    }
}