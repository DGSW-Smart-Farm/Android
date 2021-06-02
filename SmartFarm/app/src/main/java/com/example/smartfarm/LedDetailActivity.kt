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
import com.example.smartfarm.databinding.ActivityLedDetailBinding

class LedDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityLedDetailBinding
    lateinit var spannable : SpannableStringBuilder

    private val onoffpickerValue = arrayOf("off", "on")

    var ledValue : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_led_detail)
        binding.ledDetail = this

        binding.ledonoffpicker.minValue = 0
        binding.ledonoffpicker.maxValue = onoffpickerValue.size - 1
        binding.ledonoffpicker.displayedValues = onoffpickerValue

        binding.LedImage.bringToFront() // 사진 앞으로 내보내기

        getLedValue()

        setStateImg()

        initTextView()
    }

    private fun getLedValue() {
        var intent = intent
        if (intent.hasExtra("ledValue")) {
            ledValue = intent.getBooleanExtra("ledValue", false)
        }
    }

    private fun setStateImg(){
        if (ledValue == true) {
            binding.ledStateImg.setImageResource(R.drawable.led_state_img)
        } else {
            binding.ledStateImg.setImageResource(R.drawable.ledoff)
        }
    }

    fun initTextView() {
        if (ledValue == false){
            val str : String = "LED 기능이 꺼져있어요"
            spannable = SpannableStringBuilder(str)
            spannable.setSpan(
                ForegroundColorSpan(Color.BLACK),
                0, 7,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            spannable.setSpan(
                StyleSpan(Typeface.BOLD),
                0, 7,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
        } else if (ledValue == true) {
            val str: String = "LED 기능이 켜져있어요"
            spannable = SpannableStringBuilder(str)
            spannable.setSpan(
                ForegroundColorSpan(Color.BLACK),
                0, 7,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            spannable.setSpan(
                StyleSpan(Typeface.BOLD),
                0, 7,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
        } else {
            val str : String = "값을 전달받지 못했습니다"
            spannable = SpannableStringBuilder(str)
            spannable.setSpan(
                ForegroundColorSpan(Color.BLACK),
                0, 7,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            spannable.setSpan(
                StyleSpan(Typeface.BOLD),
                0, 7,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
        }
    }

    fun onOffBtnOnclick() { // numberPicker 버튼 클릭 시
        Log.d("123", "${binding.ledonoffpicker.value}")
    }

    fun backBtnOnclick() {
        finish()
    }

}