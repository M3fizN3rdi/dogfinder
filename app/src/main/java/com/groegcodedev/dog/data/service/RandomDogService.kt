package com.groegcodedev.dog.data.service

import com.groegcodedev.dog.data.dto.reponse.RandomDogResponse
import retrofit2.Response
import retrofit2.http.GET

interface RandomDogService {

    @GET("breeds/image/random")

    suspend fun getRandomDog(): Response<RandomDogResponse>
}