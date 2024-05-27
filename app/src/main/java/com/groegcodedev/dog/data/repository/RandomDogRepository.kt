package com.groegcodedev.dog.data.repository

import com.groegcodedev.dog.data.dto.reponse.RandomDogResponse
import com.groegcodedev.dog.data.service.RandomDogServiceImp
import retrofit2.Response

class RandomDogRepository(private val service: RandomDogServiceImp = RandomDogServiceImp()) {
    suspend fun getRandomDogs(): Response<RandomDogResponse> {
        return service.getRandomDogs()
    }
}