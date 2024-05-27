package com.groegcodedev.dog.data.service

import com.groegcodedev.dog.data.dto.reponse.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogService {
    @GET("breeds/image/random/13")
    suspend fun getDogs(): Response<DogResponse>
}