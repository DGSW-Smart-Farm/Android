package com.example.smartfarm.network

import com.example.smartfarm.network.api.FarmService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConnection {

    val gson: Gson = GsonBuilder().setLenient().create()

    val retrofit: Retrofit = Retrofit.Builder().baseUrl("10.80.163.68:8000/v1/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    var farmService: FarmService = retrofit.create(FarmService::class.java)
}