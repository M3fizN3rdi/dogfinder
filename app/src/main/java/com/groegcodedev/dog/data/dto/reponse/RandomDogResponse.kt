package com.groegcodedev.dog.data.dto.reponse

import com.google.gson.annotations.SerializedName

data class RandomDogResponse(
    @SerializedName("message")
    val message: String?,

    @SerializedName("status")
    val status: String?
)
