package com.ewalabs.work_manager.di

import androidx.work.WorkManager
import com.ewalabs.work_manager.QuoteWorkManager
import com.ewalabs.work_manager.repository.QuoteTaskRepository
import com.ewalabs.work_manager.repository.QuoteTaskRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 20/12/22
 */
val workManagerModule = module {
    single { QuoteWorkManager(WorkManager.getInstance(androidContext())) }
    single<QuoteTaskRepository> { QuoteTaskRepositoryImpl(get()) }
}