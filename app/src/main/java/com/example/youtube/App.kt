package com.example.youtube

import android.app.Application
import com.example.youtube.di.networkModel
import com.example.youtube.di.repositoryModule
import com.example.youtube.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin() {

            androidLogger()
            androidContext(this@App)
            modules(listOf(viewModelModule, repositoryModule, networkModel))

        }

    }
}

