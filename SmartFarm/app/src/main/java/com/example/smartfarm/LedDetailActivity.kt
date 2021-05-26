package com.example.smartfarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.NumberPicker

class LedDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_led_detail)

        val led_onoffpicker : NumberPicker = findViewById(R.id.led_onoffpicker)
        val onoffpickerValue = arrayOf("off", "on")

        led_onoffpicker.minValue = 0
        led_onoffpicker.maxValue = onoffpickerValue.size - 1
        led_onoffpicker.displayedValues = onoffpickerValue

        val led_backbtn: ImageView = findViewById(R.id.led_backbtn)
        led_backbtn.setOnClickListener {
            finish()
        }
    }

}