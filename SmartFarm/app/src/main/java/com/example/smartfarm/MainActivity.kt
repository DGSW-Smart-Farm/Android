package com.example.smartfarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.smartfarm.databinding.ActivityMainBinding
import com.example.smartfarm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding //main.xml databinding
    lateinit var model: MainViewModel //viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
        }
        model = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.activity = this
        binding.model = model

        initStateText() //초기값 설정
        model.loadFarmService() // retrofit으로 값 전달 받기

        binding.refreshLayout.setOnRefreshListener{ // 새로고침 처리
            model.loadFarmService()
            binding.refreshLayout.isRefreshing = false // 새로고침을 완료하면 아이콘을 없앤다
        }
    }

    private fun initStateText() { //초기값 설정
        model.waterText.value = "로딩중"
        model.tempText.value = "로딩중"
        model.ledText.value = "로딩중"
    }

    fun waterStateViewClick(){ // 수분 상세화면 클릭 시
        val intent = Intent(this, WaterDetail::class.java)
        intent.putExtra("waterValue", model.waterStateValue.value)
        intent.putExtra("waterState", model.waterStateResult.value)
        startActivity(intent)
    }

    fun ledStateViewClick(){ // led 상세화면 클릭 시
        val intent = Intent(this, LedDetailActivity::class.java)
        intent.putExtra("ledValue", model.ledstatus.value)
        startActivity(intent)
    }

    fun tempStateViewClick(){ // 온도 상세화면 클릭 시
        val intent = Intent(this, TempDetail::class.java)
        intent.putExtra("tempValue", model.tempStateValue.value)
        intent.putExtra("tempState", model.tempStateResult.value)
        startActivity(intent)
    }

    fun soilStateViewClick(){
        val intent = Intent(this, SoilDetailActivity::class.java)
        intent.putExtra("soilState", model.soilStateValue.value)
        startActivity(intent)
    }

    fun cameraViewClick(){ // 카메라 상세화면 클릭 시
        Toast.makeText(this, "서비스 준비 중 입니다...", Toast.LENGTH_SHORT).show()
    }

}