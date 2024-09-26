package com.fakhrulasa.emailvalidator_composeclean

import android.app.Application
import com.fakhrulasa.emailvalidator_composeclean.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            androidContext(this@MyApp) // Provide the Android context
            modules(appModule) // Load the Koin modules
        }
    }
}