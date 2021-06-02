package com.example.smartfarm

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
    var waterState: Int = 0
    private val pickerValues = arrayOf("Off", "On") // on, off picker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_water_detail)
        binding.waterDetail = this

        binding.waterImage.bringToFront() // 사진 앞으로 가져오기

        // numberPicker setting
        binding.onOffPicker.minValue = 0
        binding.onOffPicker.maxValue = pickerValues.size - 1
        binding.onOffPicker.displayedValues = pickerValues


        // Extra 값 받아오기
        getWaterValue()

        initTextView("수분이 부족해요", "물주기 기능을 이용해 물을 주세요")
        initCircleProgress()
    }

    private fun getWaterValue() {
        var intent = getIntent()
        if (intent.hasExtra("waterValue")) {
            waterValue = intent.getIntExtra("waterValue", 0)
        }
        if (intent.hasExtra("waterState")){
            waterState = intent.getIntExtra("waterState", 0)
        }
    }

    private fun initCircleProgress() {
        binding.waterCirclebar.progress = waterValue
    }

    private fun initTextView(str1: String, str2: String) { // 설명 text 굵기 조절
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

    fun onOffBtnOnclick() { // numberPicker 버튼 클릭 시
        Log.d("123", "${binding.onOffPicker.value}")
    }

    fun backBtnOnclick() { // 메인 화면을 돌아가기
        finish()
    }
}
