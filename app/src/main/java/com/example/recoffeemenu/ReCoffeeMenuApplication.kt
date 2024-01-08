package com.example.recoffeemenu

import android.app.Application

class ReCoffeeMenuApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreferencesManager.init(this)
    }
}