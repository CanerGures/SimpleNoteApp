package com.example.simplenoteapp.view.activity

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.simplenoteapp.R
import com.example.simplenoteapp.util.extStartActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        object : CountDownTimer(6000, 1000) {
            override fun onFinish() {
                this@SplashActivity extStartActivity MainActivity::class.java
            }

            override fun onTick(millisUntilFinished: Long) {}
        }.start()
    }
}