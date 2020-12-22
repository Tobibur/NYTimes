package com.tobibur.nytimes

import android.app.Application
import com.tobibur.nytimes.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NytApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@NytApplication)
            // declare modules
            modules(listOf(networkModule))
        }
    }
}