package com.randev.work_manager.di

import androidx.work.WorkManager
import com.randev.work_manager.QuoteTask
import com.randev.work_manager.QuoteWorkManager
import com.randev.work_manager.repository.QuoteTaskRepository
import com.randev.work_manager.repository.QuoteTaskRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.dsl.worker
import org.koin.core.scope.get
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 20/12/22
 */
val workManagerModule = module {
    single { QuoteWorkManager(WorkManager.getInstance(androidContext())) }
    single<QuoteTaskRepository> { QuoteTaskRepositoryImpl(get()) }
}