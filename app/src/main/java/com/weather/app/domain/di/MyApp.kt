package com.weather.app.domain.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApp : Application() {


    override fun onCreate() {
        super.onCreate()
    }
}