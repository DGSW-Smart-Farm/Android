package com.example.smartfarm.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.smartfarm.network.RetrofitConnection
import com.example.smartfarm.network.model.getAll
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    val waterText: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val tempText: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val ledText: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val waterStateValue: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val waterStateResult: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val tempStateValue: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val tempStateResult: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val ledstatus: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val soilStateValue: MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }

    fun loadFarmService() {
        var retrofitConnection = RetrofitConnection

        Log.e("123", "${retrofitConnection}")

        val call: Call<getAll> = retrofitConnection.farmService.getSensorAll()
        call.enqueue(object : Callback<getAll> {
            override fun onFailure(call: Call<getAll>, t: Throwable) {
                Log.e("Error", "error : ${t}")
            }

            override fun onResponse(call: Call<getAll>, response: Response<getAll>) {
                Log.e("123", "성공 : ${response}")
                Log.e(
                    "123",
                    "get : ${response.body()?.humidityGnd?.value}  ${response.body()?.temp?.value}  ${response.body()?.led?.status!!}"
                )
                waterStateValue.value = response.body()?.humidityGnd?.value
                waterStateResult.value = response.body()?.humidityGnd?.status
                tempStateValue.value = response.body()?.temp?.value
                tempStateResult.value = response.body()?.temp?.status
                ledstatus.value = response.body()?.led?.status!!
                soilStateValue.value = response.body()?.fertilizer?.status

                Log.e(
                    "123",
                    "test : ${waterStateValue.value} ${tempStateValue.value} ${ledstatus.value}"
                )

                mainViewText()
            }
        })
    }

    private fun mainViewText() {
        if(ledstatus.value!!){
            ledText.value = "ON"
        } else {
            ledText.value = "OFF"
        }

        waterText.value = "${waterStateValue.value}%"
        tempText.value = "${tempStateValue.value}도"

        Log.e("123", "change : ${ledText.value}  ${waterText.value} ${tempText.value}")
    }
}

