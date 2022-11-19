package com.randev.domain.di

import com.randev.domain.usecase.anime.GetAnimeAllUseCase
import com.randev.domain.usecase.anime.GetAnimeTrendingUseCase
import com.randev.domain.usecase.category.GetCategoryAllUseCase
import com.randev.domain.usecase.manga.GetMangaAllUseCase
import com.randev.domain.usecase.manga.GetMangaTrendingUseCase
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

val useCaseModule = module {
    single { GetAnimeAllUseCase(get()) }
    single { GetAnimeTrendingUseCase(get()) }
    single { GetCategoryAllUseCase(get()) }
    single { GetMangaAllUseCase(get()) }
    single { GetMangaTrendingUseCase(get()) }
}