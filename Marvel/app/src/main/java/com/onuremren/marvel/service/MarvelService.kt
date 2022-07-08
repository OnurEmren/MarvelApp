package com.onuremren.marvel.service

import com.onuremren.marvel.model.MarvelItem
import retrofit2.Response
import retrofit2.http.GET

interface MarvelService {
    @GET("marvel/")
    suspend fun getMarvel(): Response<List<MarvelItem>>
}