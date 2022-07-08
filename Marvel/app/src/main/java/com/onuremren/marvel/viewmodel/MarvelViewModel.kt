package com.onuremren.marvel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onuremren.marvel.repo.Repository
import com.onuremren.marvel.model.MarvelItem
import kotlinx.coroutines.*

class MarvelViewModel(private val repository: Repository): ViewModel() {
    var marvelList = MutableLiveData<List<MarvelItem>>()
    var loading = MutableLiveData<Boolean>()
    var job: Job ?= null

    fun getAllMarvel(){
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getAllData()
            loading.postValue(true)
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    marvelList.postValue(response.body())
                    loading.postValue(false)
                    println(" Fonsiyon Çalıştı")
                } else{
                    print("HATA!")
                }
            }
        }

    }

    
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}