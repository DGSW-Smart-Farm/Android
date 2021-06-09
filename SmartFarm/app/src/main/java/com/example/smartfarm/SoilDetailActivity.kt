package com.example.smartfarm

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.smartfarm.databinding.ActivitySoilDetailBinding

class SoilDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivitySoilDetailBinding

    var soilState: Int = -2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_soil_detail)

        binding.soilDetail = this
        getSoilState()
        setProgress()
    }

    private fun getSoilState() {
        var intent = getIntent()
        if (intent != null) {
            soilState = intent.getIntExtra("soilState", -2)
        }
    }

    private fun setProgress() {
        var soilCondition: Int = 0

        if (soilState == 1) {
            soilCondition = 90 //토양상태

            binding.highsoilcondition.visibility = View.VISIBLE
            binding.tvMax.setTextColor(Color.parseColor("#000000"))
        } else if (soilState == 0) {
            soilCondition = 50 //토양상태

            binding.middlesoilcondition.visibility = View.VISIBLE
            binding.tvAvg.setTextColor(Color.parseColor("#000000"))
        } else if (soilState == -1) {
            soilCondition = 10

            binding.lowsoilcondition.visibility = View.VISIBLE
            binding.tvMin.setTextColor(Color.parseColor("#000000"))
        }
        binding.soilProgressbar.progress = soilCondition
    }

    fun backBtnOnclick() {
        finish()
    }
}