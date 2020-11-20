package com.example.simplenoteapp.util

import android.app.Application
import com.example.simplenoteapp.module.noteRepositoryModule
import com.example.simplenoteapp.module.roomModule
import com.example.simplenoteapp.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinApp)
            modules(
                roomModule,
                viewModelModule,
                noteRepositoryModule
            )
        }
    }
}