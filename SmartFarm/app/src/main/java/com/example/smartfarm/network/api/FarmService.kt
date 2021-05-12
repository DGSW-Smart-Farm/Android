package com.example.smartfarm.network.api

import com.example.smartfarm.network.model.getAll
import retrofit2.http.GET

interface FarmService {
    @GET("get_all_sensor")
    fun getSensorAll(): retrofit2.Call<getAll>
}