package com.example.recoffeemenu

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ReCoffeeMenuApplication : Application() {
    companion object {
        lateinit var instance: ReCoffeeMenuApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}