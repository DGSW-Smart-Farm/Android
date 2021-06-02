package com.example.smartfarm.network.model


import com.google.gson.annotations.SerializedName

data class Fertilizer(
    @SerializedName("status")
    val status: Int
)