package com.example.smartfarm.network.model


import com.google.gson.annotations.SerializedName

data class Co2(
    @SerializedName("status")
    val status: Int,
    @SerializedName("value")
    val value: Int
)