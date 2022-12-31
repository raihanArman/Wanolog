package com.randev.kiiroi.android.application

import com.randev.core.BaseApplication
import com.randev.navigation.navigatorModule
import com.randev.kiiroi.android.di.featureModule
import com.randev.kiiroi.initKoin
import com.randev.work_manager.di.workManagerModule
import com.randev.work_manager.repository.QuoteTaskRepository
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
class KiiroiApp: BaseApplication() {

    val taskRepository by inject<QuoteTaskRepository>()

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(Level.ERROR)
            androidContext(this@KiiroiApp)
            modules(
                navigatorModule,
                featureModule,
                workManagerModule
            )
        }

        taskRepository.executeQuoteWorker()

    }
}