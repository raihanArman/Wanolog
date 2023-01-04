package com.ewalabs.data.di

import com.ewalabs.data.datasource.local.AnimeFavoriteDataSource
import com.ewalabs.data.datasource.local.AnimeFavoriteDataSourceImpl
import com.ewalabs.data.datasource.local.MangaFavoriteDataSource
import com.ewalabs.data.datasource.local.MangaFavoriteDataSourceImpl
import com.ewalabs.data.datasource.local.QuoteFavoriteDataSource
import com.ewalabs.data.datasource.local.QuoteFavoriteDataSourceImpl
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 25/12/22
 */
val dataSourceModule = module {
    single<AnimeFavoriteDataSource> { AnimeFavoriteDataSourceImpl(get()) }
    single<MangaFavoriteDataSource> { MangaFavoriteDataSourceImpl(get()) }
    single<QuoteFavoriteDataSource> { QuoteFavoriteDataSourceImpl(get()) }
}