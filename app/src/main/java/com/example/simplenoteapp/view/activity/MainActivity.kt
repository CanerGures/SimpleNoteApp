package com.example.simplenoteapp.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplenoteapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*this.overridePendingTransition(
            R.anim.anim_enter,
            R.anim.anim_leave
        )*/
    }

}