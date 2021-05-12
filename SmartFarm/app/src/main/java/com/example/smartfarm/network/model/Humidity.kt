package com.example.smartfarm.network.model


import com.google.gson.annotations.SerializedName

data class Humidity(
    @SerializedName("status")
    val status: Int,
    @SerializedName("value")
    val value: Int
)