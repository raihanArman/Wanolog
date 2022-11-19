package com.randev.data.di

import com.randev.data.datasource.remote.AnimeApi
import com.randev.data.datasource.remote.AnimeApiClient
import com.randev.data.datasource.remote.CategoryApi
import com.randev.data.datasource.remote.CategoryApiClient
import com.randev.data.datasource.remote.MangaApi
import com.randev.data.datasource.remote.MangaApiClient
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

val clientModule = module {
    single<AnimeApiClient> { AnimeApi(get()) }
    single<CategoryApiClient> { CategoryApi(get()) }
    single<MangaApiClient> { MangaApi(get()) }
}