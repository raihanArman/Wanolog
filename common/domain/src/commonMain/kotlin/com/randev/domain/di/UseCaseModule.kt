package com.randev.domain.di

import com.randev.domain.usecase.GetAnimeAllUseCase
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

val useCaseModule = module {
    single { GetAnimeAllUseCase(get()) }
}