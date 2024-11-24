package com.ponomarenko.skeleton.infrastructure

import android.app.Application
import android.content.Context
import com.ponomarenko.skeleton.infrastructure.di.InjectionModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    private fun Context.setupKoin() {
        startKoin {
            androidContext(this@setupKoin.applicationContext)

            modules(InjectionModules.modules)
        }
    }
}