package com.randev.data.di

import com.randev.data.repository.AnimeRepositoryImpl
import com.randev.data.repository.CategoryRepositoryImpl
import com.randev.data.repository.CharacterRepositoryImpl
import com.randev.data.repository.MangaRepositoryImpl
import com.randev.domain.repository.AnimeRepository
import com.randev.domain.repository.CategoryRepository
import com.randev.domain.repository.CharacterRepository
import com.randev.domain.repository.MangaRepository
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

val repositoryModule = module {
    single<AnimeRepository> { AnimeRepositoryImpl(get(), get(), get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get(), get()) }
    single<MangaRepository> { MangaRepositoryImpl(get(), get()) }
    single<CharacterRepository> { CharacterRepositoryImpl(get(), get()) }
}