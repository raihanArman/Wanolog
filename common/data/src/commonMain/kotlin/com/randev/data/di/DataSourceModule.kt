package com.randev.data.di

import com.randev.data.datasource.local.AnimeFavoriteDataSource
import com.randev.data.datasource.local.AnimeFavoriteDataSourceImpl
import com.randev.data.datasource.local.MangaFavoriteDataSource
import com.randev.data.datasource.local.MangaFavoriteDataSourceImpl
import com.randev.data.datasource.local.QuoteFavoriteDataSource
import com.randev.data.datasource.local.QuoteFavoriteDataSourceImpl
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