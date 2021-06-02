package com.example.smartfarm.network.api

import com.example.smartfarm.network.model.getAll
import retrofit2.http.FieldMap
import retrofit2.http.GET
import retrofit2.http.POST

interface FarmService {
    @GET("get_all_sensor")
    fun getSensorAll(): retrofit2.Call<getAll>

//    @POST("control_water")
//    fun postControlWater(
//        @FieldMap
//        param: HashMap<String, String>
//    ): retrofit2.Call<controlWaterResult>
}