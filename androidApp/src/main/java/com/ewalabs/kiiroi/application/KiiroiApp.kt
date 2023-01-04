package com.ewalabs.kiiroi.application

import com.ewalabs.core.BaseApplication
import com.ewalabs.navigation.navigatorModule
import com.ewalabs.kiiroi.di.featureModule
import com.ewalabs.kiiroi.initKoin
import com.ewalabs.work_manager.di.workManagerModule
import com.ewalabs.work_manager.repository.QuoteTaskRepository
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
class KiiroiApp: BaseApplication() {

    private val taskRepository by inject<QuoteTaskRepository>()

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