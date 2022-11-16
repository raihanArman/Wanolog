package com.randev.data.di

import com.randev.data.datasource.remote.AnimeApi
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

val clientModule = module {
    single { AnimeApi(get()) }
}