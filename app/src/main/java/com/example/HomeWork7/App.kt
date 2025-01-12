package com.example.HomeWork7

import android.app.Application
import com.example.HomeWork7.di.youtubeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App :Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
            modules(youtubeModule)
        }
    }
}