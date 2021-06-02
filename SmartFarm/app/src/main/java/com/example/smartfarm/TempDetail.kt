package com.example.smartfarm

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.smartfarm.databinding.ActivityTemperatureDetailBinding

class TempDetail : AppCompatActivity() {
    lateinit var binding: ActivityTemperatureDetailBinding
    lateinit var spannable1: SpannableStringBuilder
    lateinit var spannable2: SpannableStringBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_temperature_detail)

        binding.tempDetail = this
        binding.tempImage.bringToFront()

        getTempValue()
        initTextView("적당한 온도에요", "정말 기분이 좋은 날 입니다.....")
    }

    private fun getTempValue() {
        val intent = intent
        var temp: Int = intent.getIntExtra("tempValue", 0)

        setCircleProgress(temp)
    }

    private fun setCircleProgress(temp: Int) {
        binding.tempCirclebar.progress = temp
    }

    private fun initTextView(str1: String, str2: String) {
        spannable1 = SpannableStringBuilder(str1)
        spannable1.setSpan(
            ForegroundColorSpan(Color.BLACK),
            0, // start
            6, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        spannable1.setSpan(
            StyleSpan(Typeface.BOLD),
            0, // start
            6, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        spannable2 = SpannableStringBuilder(str2)
        spannable2.setSpan(
            ForegroundColorSpan(Color.BLACK),
            0, // start
            12, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        spannable2.setSpan(
            StyleSpan(Typeface.BOLD),
            0, // start
            12, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
    }

    fun backBtnOnclick() { // 메인 화면을 돌아가기
        finish()
    }
}