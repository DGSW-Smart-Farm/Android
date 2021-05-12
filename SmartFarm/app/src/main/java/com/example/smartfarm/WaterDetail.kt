package com.example.smartfarm

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.smartfarm.databinding.ActivityWaterDetailBinding

class WaterDetail : AppCompatActivity() {
    lateinit var binding: ActivityWaterDetailBinding
    lateinit var spannable1: SpannableStringBuilder
    lateinit var spannable2: SpannableStringBuilder

    var waterValue: Int = 0
    private val pickerValues = arrayOf("Off", "On")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_water_detail)
        binding.waterDetail = this

        binding.waterImage.bringToFront()
        binding.onOffPicker.minValue = 0
        binding.onOffPicker.maxValue = pickerValues.size - 1
        binding.onOffPicker.displayedValues = pickerValues


        getWaterValue()

        initTextView("수분이 부족해요", "물주기 기능을 이용해 물을 주세요")
        initCircleProgress()
    }

    private fun getWaterValue() {
        var intent = getIntent()
        if (intent.hasExtra("waterValue")) {
            waterValue = intent.getIntExtra("waterValue", 0)
        }
    }

    private fun initCircleProgress() {
        binding.waterCirclebar.progress = waterValue
    }

    private fun initTextView(str1: String, str2: String) {
        spannable1 = SpannableStringBuilder(str1)
        spannable1.setSpan(
            ForegroundColorSpan(Color.BLACK),
            0, // start
            2, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        spannable1.setSpan(
            StyleSpan(Typeface.BOLD),
            0, // start
            2, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        spannable2 = SpannableStringBuilder(str2)
        spannable2.setSpan(
            ForegroundColorSpan(Color.BLACK),
            0, // start
            6, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        spannable2.setSpan(
            StyleSpan(Typeface.BOLD),
            0, // start
            6, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
    }

    fun onOffBtnOnclick() {
        Log.d("123", "${binding.onOffPicker.value}")
    }

    fun backBtnOnclick() {
        finish()
    }
}
