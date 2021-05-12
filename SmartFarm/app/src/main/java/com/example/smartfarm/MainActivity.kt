package com.example.smartfarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.smartfarm.databinding.ActivityMainBinding
import com.example.smartfarm.databinding.ActivityWaterDetailBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
    }

    fun waterStateViewClick(){
        val intent = Intent(this, WaterDetail::class.java)
        intent.putExtra("waterValue", 50)
        startActivity(intent)
    }

    fun ledStateViewClick(){
        val intent = Intent(this, LedDetailActivity::class.java)
        intent.putExtra("ledValue", 255)
        startActivity(intent)
    }

}