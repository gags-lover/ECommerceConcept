package com.github.astat1cc.sergeybalakintesttask

import android.app.Application
import android.util.Log
import com.github.astat1cc.sergeybalakintesttask.di.databaseModule
import com.github.astat1cc.sergeybalakintesttask.di.networkModule
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.di.cartScreenModule
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.di.detailsScreenModule
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.di.mainScreenModule
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
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
            modules(
                networkModule,
                mainScreenModule,
                cartScreenModule,
                detailsScreenModule,
                databaseModule
            )
        }
    }
}