package com.randev.wanolog

import com.randev.data.di.clientModule
import com.randev.data.di.dataSourceModule
import com.randev.data.di.mapperModule
import com.randev.data.di.persistanceModule
import com.randev.data.di.repositoryModule
import com.randev.database.databaseModule
import com.randev.domain.di.useCaseModule
import com.randev.network.ktorEngineModule
import com.randev.network.networkModule
import com.randev.preferences.preferencesModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

/**
 * @author Raihan Arman
 * @date 11/10/22
 */

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        databaseModule() +
        ktorEngineModule() +
        preferencesModule +
        dataSourceModule +
        networkModule +
        clientModule +
        persistanceModule +
        mapperModule +
        repositoryModule +
        useCaseModule
    )
}

fun initKoin() = initKoin {}