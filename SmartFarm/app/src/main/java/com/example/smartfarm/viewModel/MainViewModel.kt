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
                    "${response.body()?.humidityGnd?.value}  ${response.body()?.temp?.value}  ${response.body()?.led?.status!!}"
                )
                MainViewModel().waterStateValue.value = response.body()?.humidityGnd?.value
                MainViewModel().waterStateResult.value = response.body()?.humidityGnd?.status
                MainViewModel().tempStateValue.value = response.body()?.temp?.value
                MainViewModel().tempStateResult.value = response.body()?.temp?.status
                MainViewModel().ledstatus.value = response.body()?.led?.status!!

                Log.e(
                    "123",
                    "${MainViewModel().waterStateValue.value} ${MainViewModel().tempStateValue.value} ${MainViewModel().ledstatus.value}"
                )

                mainViewText()
            }
        })
    }

    private fun mainViewText() {
        if(MainViewModel().ledstatus.value!!){
            MainViewModel().ledText.value = "ON"
        } else {
            MainViewModel().ledText.value = "OFF"
        }

        MainViewModel().waterText.value = "${MainViewModel().waterStateValue.value}%"
        MainViewModel().tempText.value = "${MainViewModel().tempStateValue.value}도"

        Log.e("123", "${MainViewModel().ledText.value}  ${MainViewModel().waterText.value} ${MainViewModel().tempText.value}")
    }
}

