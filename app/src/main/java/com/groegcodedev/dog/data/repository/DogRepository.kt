package com.groegcodedev.dog.data.repository

import com.groegcodedev.dog.data.dto.reponse.DogResponse
import com.groegcodedev.dog.data.service.DogServiceImp
import retrofit2.Response

class DogRepository(private val service: DogServiceImp = DogServiceImp()) {
    suspend fun getDogs(): Response<DogResponse> {
        return service.getDogs()
    }
}