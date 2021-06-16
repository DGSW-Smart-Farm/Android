package com.example.smartfarm

import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.smartfarm.databinding.ActivityWaterDetailBinding
import com.example.smartfarm.network.RetrofitConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

        initTextView()
        setCircleProgress()
    }

    private fun getWaterValue() {
        var intent = intent
        if (intent.hasExtra("waterValue")) {
            waterValue = intent.getIntExtra("waterValue", 0)
        }
        if (intent.hasExtra("waterState")) {
            waterState = intent.getIntExtra("waterState", -2)
        } else {
            waterState = -2; // 값을 전달 받지 못했을 때
        }
    }

    private fun setCircleProgress() {
        val animator = ValueAnimator.ofInt(0, waterValue)
        animator.addUpdateListener {
            val progress = animator.animatedValue as Int
            binding.waterCirclebar.progress = progress
        }
        animator.duration = 1500
        animator.start()
    }

    private fun initTextView() { // 설명 text 굵기 조절
        if (waterState == -1) {
            val str1: String = "수분이 부족해요"
            val str2: String = "물주기 기능을 이용해 물을 주세요"

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
        } else if (waterState == 0) {
            val str1: String = "수분이 적당해요"
            val str2: String = "수분이 아주 완벽한 상태에요"

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
                3, // start
                9, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            spannable2.setSpan(
                StyleSpan(Typeface.BOLD),
                3, // start
                9, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
        } else if (waterState == 1) {
            val str1: String = "수분이 과해요"
            val str2: String = "과유불급"

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
                3, // end
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            spannable2.setSpan(
                StyleSpan(Typeface.BOLD),
                0, // start
                3, // end
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

    fun onOffBtnOnclick() { // numberPicker 버튼 클릭 시
        if(waterState != -2){
            var retrofitConnection = RetrofitConnection
            var statusValue: Boolean = false

            statusValue = binding.onOffPicker.value != 0
            val params = HashMap<String?, Boolean?>()
            params["status"] = statusValue

            val call: Call<Void> = retrofitConnection.farmService.postControlWater(params)
            call.enqueue(object : Callback<Void> {
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d("postError", "$t")
                    Toast.makeText(applicationContext, "스마트 팜으로 수분 상태 요청을 실패했습니다.", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Log.d("post", "${response.body()}")
                    Toast.makeText(applicationContext, "스마트 팜으로 수분 상태 요청을 성공했습니다.", Toast.LENGTH_SHORT).show()
                }

            })
        } else {
            Toast.makeText(this, "서버와 연결 되어있지 않습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    fun backBtnOnclick() { // 메인 화면을 돌아가기
        finish()
    }
}
