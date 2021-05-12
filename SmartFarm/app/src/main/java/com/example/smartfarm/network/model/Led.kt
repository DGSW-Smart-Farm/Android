package com.example.smartfarm.network.model


import com.google.gson.annotations.SerializedName

data class Led(
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("time")
    val time: Int
)