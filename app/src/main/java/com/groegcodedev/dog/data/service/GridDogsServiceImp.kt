package com.groegcodedev.dog.data.service

import com.groegcodedev.dog.data.dto.reponse.DogResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class GridDogsServiceImp {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val serviceGrid = retrofit.create<GridDogsService>()

    suspend fun getGridDogs(): Response<DogResponse> {
        return serviceGrid.getGridDogs()
    }
}