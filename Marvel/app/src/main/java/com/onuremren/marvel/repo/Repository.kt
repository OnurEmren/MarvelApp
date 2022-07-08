package com.onuremren.marvel.repo

import com.onuremren.marvel.service.MarvelService

class Repository(private val retrofitService: MarvelService) {
    suspend fun getAllData() = retrofitService.getMarvel()
}