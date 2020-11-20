package com.example.simplenoteapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.simplenoteapp.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationController =
            Navigation.findNavController(
                this,
                R.id.nav_host_fragment_container
            )
        val navigationView = NavigationView(this)
        NavigationUI.setupWithNavController(navigationView, navigationController)

    }


}