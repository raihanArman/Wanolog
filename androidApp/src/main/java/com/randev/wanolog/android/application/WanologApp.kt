package com.randev.wanolog.android.application

import android.app.Application
import com.randev.wanolog.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
class WanologApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(Level.ERROR)
            androidContext(this@WanologApp)
            modules(
//                navigatorModule,
//                featureModule,
            )
        }
    }
}