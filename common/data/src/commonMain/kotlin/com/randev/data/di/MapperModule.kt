package com.randev.data.di

import com.randev.data.mapper.AnimeListMapper
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

val mapperModule = module {
    single { AnimeListMapper() }
}