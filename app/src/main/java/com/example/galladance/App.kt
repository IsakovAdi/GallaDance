package com.example.galladance

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this@App
    }

    companion object {
            lateinit var instance: App
                private set
    }
}