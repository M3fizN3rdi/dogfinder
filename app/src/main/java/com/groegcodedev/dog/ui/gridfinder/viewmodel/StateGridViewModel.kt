package com.groegcodedev.dog.ui.gridfinder.viewmodel

import com.groegcodedev.dog.data.dto.reponse.DogResponse

open class StateGridViewModel {
    data class Sucess(val info: DogResponse) : StateGridViewModel()
    data class Error(val message: String) : StateGridViewModel()
}