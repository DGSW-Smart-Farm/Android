package com.example.smartfarm.network.api

import com.example.smartfarm.network.model.getAll
import retrofit2.http.*

interface FarmService {
    @GET("get_all_sensor")
    fun getSensorAll(): retrofit2.Call<getAll>

    @FormUrlEncoded
    @POST("control_water/")
    fun postControlWater(
        @FieldMap
        params: HashMap<String?, Boolean?>
    ): retrofit2.Call<Void>

    @FormUrlEncoded
    @POST("control_led/")
    fun postControlLed(
        @FieldMap
        params: HashMap<String?, Boolean?>
    ): retrofit2.Call<Void>
}