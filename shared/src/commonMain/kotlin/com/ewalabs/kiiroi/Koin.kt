package com.ewalabs.kiiroi

import com.ewalabs.data.di.clientModule
import com.ewalabs.data.di.dataSourceModule
import com.ewalabs.data.di.mapperModule
import com.ewalabs.data.di.persistanceModule
import com.ewalabs.data.di.repositoryModule
import com.ewalabs.database.databaseModule
import com.ewalabs.domain.di.useCaseModule
import com.ewalabs.network.ktorEngineModule
import com.ewalabs.network.networkModule
import com.ewalabs.preferences.preferencesModule
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