package com.onuremren.marvel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onuremren.marvel.R
import com.onuremren.marvel.databinding.ItemMovieBinding
import com.onuremren.marvel.model.MarvelItem

class MarvelAdapter:RecyclerView.Adapter<MarvelAdapter.MarvelViewHolder>() {
    var marvelList = mutableListOf<MarvelItem>()

    class MarvelViewHolder(val item: ItemMovieBinding): RecyclerView.ViewHolder(item.root){

    }
    fun getMarvelData(marvels: List<MarvelItem>){
        this.marvelList = marvels.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarvelAdapter.MarvelViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemMovieBinding>(inflater, R.layout.item_movie,parent,false)
        return MarvelViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarvelAdapter.MarvelViewHolder, position: Int) {
        val movie = marvelList[position]
        holder.item.movies = marvelList[position]
        Glide.with(holder.itemView.context).load(movie.imageurl).into(holder.item.imageview)  }

    override fun getItemCount(): Int {
        return marvelList.size
    }
}

