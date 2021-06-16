package com.example.smartfarm

import android.animation.ValueAnimator
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

    var tempValue: Int = 0
    var tempState: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_temperature_detail)

        binding.tempDetail = this
        binding.tempImage.bringToFront()

        getTempValue()
        initTextView()

        setCircleProgress(tempValue)
    }

    private fun getTempValue() {
        val intent = intent
        if (intent.hasExtra("tempValue")) {
            tempValue = intent.getIntExtra("tempValue", 0)
        }
        if (intent.hasExtra("tempState")) {
            tempState = intent.getIntExtra("tempState", -2)
        }
    }

    private fun setCircleProgress(tempValue: Int) {
        val animator = ValueAnimator.ofInt(0, tempValue)
        animator.addUpdateListener {
            val progress = animator.animatedValue as Int
            binding.tempCirclebar.progress = progress
        }

        binding.tempText.text = "${tempValue}도"
        animator.duration = 1500
        animator.start()
    }

    private fun initTextView() {
        if (tempState == -1) {
            val str1: String = "적당한 온도에요"
            val str2: String = "정말 기분이 좋은 날 입니다..."
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
                6, // start
                10, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            spannable2.setSpan(
                StyleSpan(Typeface.BOLD),
                6, // start
                10, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
        } else if (tempState == 0){
            val str1: String = "온도가 낮아요"
            val str2: String = "정말 추운날 입니다..."
            spannable1 = SpannableStringBuilder(str1)
            spannable1.setSpan(
                ForegroundColorSpan(Color.BLACK),
                0, // start
                7, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            spannable1.setSpan(
                StyleSpan(Typeface.BOLD),
                0, // start
                7, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )

            spannable2 = SpannableStringBuilder(str2)
            spannable2.setSpan(
                ForegroundColorSpan(Color.BLACK),
                2, // start
                6, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            spannable2.setSpan(
                StyleSpan(Typeface.BOLD),
                2, // start
                6, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
        } else if (tempState == 1){
            val str1: String = "온도가 높아요"
            val str2: String = "정말 더운날 입니다..."
            spannable1 = SpannableStringBuilder(str1)
            spannable1.setSpan(
                ForegroundColorSpan(Color.BLACK),
                0, // start
                7, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            spannable1.setSpan(
                StyleSpan(Typeface.BOLD),
                0, // start
                7, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )

            spannable2 = SpannableStringBuilder(str2)
            spannable2.setSpan(
                ForegroundColorSpan(Color.BLACK),
                2, // start
                6, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            spannable2.setSpan(
                StyleSpan(Typeface.BOLD),
                2, // start
                6, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
        } else {
            spannable1 = SpannableStringBuilder("값을 전달받지")
            spannable1.setSpan(
                ForegroundColorSpan(Color.BLACK),
                0, // start
                7, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            spannable1.setSpan(
                StyleSpan(Typeface.BOLD),
                0, // start
                7, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            spannable2 = SpannableStringBuilder("못했습니다.")
        }
    }

    fun backBtnOnclick() { // 메인 화면을 돌아가기
        finish()
    }
}