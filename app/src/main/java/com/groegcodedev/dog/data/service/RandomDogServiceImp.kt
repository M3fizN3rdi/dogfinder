package com.groegcodedev.dog.data.service

import com.groegcodedev.dog.data.dto.reponse.RandomDogResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RandomDogServiceImp {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create<RandomDogService>()

    suspend fun getRandomDogs(): Response<RandomDogResponse> {
        return service.getRandomDog()
    }
}