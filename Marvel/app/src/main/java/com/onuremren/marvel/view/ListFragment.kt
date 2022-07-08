package com.onuremren.marvel.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.onuremren.marvel.R
import com.onuremren.marvel.adapter.MarvelAdapter
import com.onuremren.marvel.databinding.FragmentListBinding
import com.onuremren.marvel.repo.Repository
import com.onuremren.marvel.service.Marvelnterface
import com.onuremren.marvel.viewmodel.MarvelViewModel
import com.onuremren.marvel.viewmodel.MyViewModelFactory


class ListFragment : Fragment() {

    private val retrofitService = Marvelnterface.getInstance()
    lateinit var viewModel: MarvelViewModel
    private lateinit var dataBinding: FragmentListBinding
    val adapter = MarvelAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_list,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this,MyViewModelFactory(Repository(retrofitService)))
            .get(MarvelViewModel::class.java)
        dataBinding.recyclerview.adapter = adapter


        viewModel.marvelList.observe(viewLifecycleOwner, Observer {
            adapter.getMarvelData(it)
        })

        viewModel.loading.observe(viewLifecycleOwner){
            if (it) {
                dataBinding.progressDialog.visibility = View.VISIBLE
            } else{
                dataBinding.progressDialog.visibility = View.INVISIBLE
            }
        }
        viewModel.getAllMarvel()
    }
}