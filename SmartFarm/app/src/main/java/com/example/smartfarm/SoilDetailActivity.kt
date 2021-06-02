package com.example.smartfarm

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.smartfarm.R

class SoilDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soil_detail)

        var soilCondition:Int = 50 //토양상태
        val soilProgressbar:ProgressBar = findViewById(R.id.soil_progressbar)
        val tvMax:TextView = findViewById(R.id.tv_max)
        val tvavg:TextView = findViewById(R.id.tv_avg)
        val tvmin:TextView = findViewById(R.id.tv_min)
        val lowsoilcondition:ImageView = findViewById(R.id.lowsoilcondition)
        val middlesoilcondition:ImageView = findViewById(R.id.middlesoilcondition)
        val highsoilcondition:ImageView = findViewById(R.id.highsoilcondition)

        soilProgressbar.progress = soilCondition

        if(soilCondition > 65){
            tvMax.setTextColor(Color.parseColor("#000000"))
            highsoilcondition.visibility = View.VISIBLE
        }
        else if(soilCondition > 35){
            tvavg.setTextColor(Color.parseColor("#000000"))
            middlesoilcondition.visibility = View.VISIBLE
        }
        else{
            tvmin.setTextColor(Color.parseColor("#000000"))
            lowsoilcondition.visibility = View.VISIBLE
        }
    }
}