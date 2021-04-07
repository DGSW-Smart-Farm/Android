package com.example.smartfarm

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.dinuscxj.progressbar.CircleProgressBar
import com.example.smartfarm.R
import org.w3c.dom.Text

class MoistureDetailScreen : AppCompatActivity(), CircleProgressBar.ProgressFormatter {

    private val DEFAULT_PATTERN = "%d%%"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moisture_detail_screen)

        val waterToolbar: Toolbar = findViewById(R.id.toolbar_water) //커스텀 액션바 (toolbar)
        setSupportActionBar(waterToolbar)
        val ab: ActionBar = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)

        var moisture: Int //수분
        val circleProgressBar: CircleProgressBar = findViewById(R.id.cpb_circlebar)
        moisture = 70

        circleProgressBar.setProgress(moisture)

        var waterMl: Int = 600
        var textViewWater: TextView = findViewById(R.id.tv_ml)
        textViewWater.setText("$waterMl ML")

        var textViewPercent: TextView = findViewById(R.id.tv_percent)
        textViewPercent.setText("$moisture %")

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun format(progress: Int, max: Int): CharSequence {
        return String.format(DEFAULT_PATTERN, (progress.toFloat() / max.toFloat() * 100).toInt())
    }


}