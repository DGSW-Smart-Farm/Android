package com.example.smartfarm

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.smartfarm.R

class SoilDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soil_detail)

        var soilCondition:Int = 70 //토양상태
        val soilProgressbar:ProgressBar = findViewById(R.id.soil_progressbar)
        val tvMax:TextView = findViewById(R.id.tv_max)
        val tvavg:TextView = findViewById(R.id.tv_avg)
        val tvmin:TextView = findViewById(R.id.tv_min)

        soilProgressbar.progress = soilCondition

        if(soilCondition > 65){
            tvMax.setTextColor(Color.parseColor("#000000"))
        }
        else if(soilCondition > 35){
            tvavg.setTextColor(Color.parseColor("#000000"))
        }
        else{
            tvmin.setTextColor(Color.parseColor("#000000"))
        }
    }
}