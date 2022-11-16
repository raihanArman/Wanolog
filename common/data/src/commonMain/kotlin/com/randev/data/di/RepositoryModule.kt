package com.randev.data.di

import com.randev.data.repository.AnimeRepositoryImpl
import com.randev.domain.repository.AnimeRepository
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

val repositoryModule = module {
    single<AnimeRepository> { AnimeRepositoryImpl(get(), get()) }
}