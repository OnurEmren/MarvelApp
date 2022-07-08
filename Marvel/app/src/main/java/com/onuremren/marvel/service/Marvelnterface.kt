package com.onuremren.marvel.service

import com.onuremren.marvel.model.MarvelItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Marvelnterface {
    @GET("marvel")
    fun getData(): Response<List<MarvelItem>>

    companion object{
        var marvelService: MarvelService ?= null
        fun getInstance(): MarvelService{
            if (marvelService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.simplifiedcoding.net/demos/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                marvelService = retrofit.create(MarvelService::class.java)
            }
            return marvelService!!

        }
    }

}