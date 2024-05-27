package com.groegcodedev.dog.ui.home.viewmodel

import com.groegcodedev.dog.data.dto.reponse.DogResponse

sealed class StateViewModel {
    data class Success(val info: DogResponse) : StateViewModel()
    data class Error(val message: String) : StateViewModel()
    data object  Loading : StateViewModel()
}