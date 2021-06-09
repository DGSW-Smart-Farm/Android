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
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.smartfarm.databinding.ActivityLedDetailBinding
import com.example.smartfarm.network.RetrofitConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        if (ledValue) {
            binding.ledStateImg.setImageResource(R.drawable.led_state_img)
            binding.ledonoffpicker.value = 1
        } else {
            binding.ledStateImg.setImageResource(R.drawable.ledoff)
            binding.ledonoffpicker.value = 0
        }
    }

    private fun initTextView() {
        if (!ledValue){
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
        } else if (ledValue) {
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
        var retrofitConnection = RetrofitConnection
        var statusValue: Boolean = false

        statusValue = binding.ledonoffpicker.value != 0
        val params = HashMap<String?, Boolean?>()
        params["status"] = statusValue


        val call: Call<Void> = retrofitConnection.farmService.postControlLed(params)
        call.enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.d("postError", "$t")
                Toast.makeText(applicationContext, "스마트 팜으로 LED 상태 요청을 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Log.d("post", "${response.body()}")
                Toast.makeText(applicationContext, "스마트 팜으로 LED 상태 요청을 성공했습니다.", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun backBtnOnclick() {
        finish()
    }

}