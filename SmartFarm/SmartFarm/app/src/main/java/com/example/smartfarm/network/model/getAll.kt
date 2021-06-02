package com.example.smartfarm.network.model


import com.google.gson.annotations.SerializedName

data class getAll(
    @SerializedName("co2")
    val co2: Co2,
    @SerializedName("fertilizer")
    val fertilizer: Fertilizer,
    @SerializedName("humidity")
    val humidity: Humidity,
    @SerializedName("humidity_gnd")
    val humidityGnd: HumidityGnd,
    @SerializedName("led")
    val led: Led,
    @SerializedName("temp")
    val temp: Temp
)