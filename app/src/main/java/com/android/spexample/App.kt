package com.android.spexample

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        SharedPreferences.load(applicationContext)
    }

}