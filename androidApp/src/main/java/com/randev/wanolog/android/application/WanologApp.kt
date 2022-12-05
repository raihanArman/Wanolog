package com.randev.wanolog.android.application

import android.app.Application
import com.randev.core.BaseApplication
import com.randev.navigation.navigatorModule
import com.randev.wanolog.android.di.featureModule
import com.randev.wanolog.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
class WanologApp: BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(Level.ERROR)
            androidContext(this@WanologApp)
            modules(
                navigatorModule,
                featureModule,
            )
        }
    }
}