package com.groegcodedev.dog.data.repository

import com.groegcodedev.dog.data.dto.reponse.DogResponse
import com.groegcodedev.dog.data.service.GridDogsServiceImp
import retrofit2.Response

class GridDogsRepository(private val service: GridDogsServiceImp = GridDogsServiceImp()) {
    suspend fun getGridDogs(): Response<DogResponse> {
        return service.getGridDogs()
    }
}