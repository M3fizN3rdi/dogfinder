package com.groegcodedev.dog.ui.random.viewmodel

import com.groegcodedev.dog.data.dto.reponse.RandomDogResponse

open class StateRandomDogViewModel {
    data class Success(val info: RandomDogResponse) : StateRandomDogViewModel()
    data class Error(val message: String) : StateRandomDogViewModel()
    data object Loading : StateRandomDogViewModel()
}