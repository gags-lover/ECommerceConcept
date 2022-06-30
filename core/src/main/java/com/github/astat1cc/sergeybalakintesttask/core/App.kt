package com.github.astat1cc.sergeybalakintesttask.core

import android.app.Application
import com.github.astat1cc.sergeybalakintesttask.core.di.networkModule
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.presentation.di.cartScreenModule
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.di.mainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(networkModule, mainScreenModule, cartScreenModule)
        }
    }
}