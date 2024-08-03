package com.example.otstest

import android.app.Application
import com.example.otstest.di.koinAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(koinAppModule)
        }
    }
}