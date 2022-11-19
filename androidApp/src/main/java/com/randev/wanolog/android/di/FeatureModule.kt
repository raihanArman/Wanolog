package com.randev.wanolog.android.di

import com.randev.wanolog.android.presentation.home.HomeViewModel
import com.randev.wanolog.android.presentation.home.anime.AnimeViewModel
import com.randev.wanolog.android.presentation.home.manga.MangaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

val featureModule = module {
    viewModel { AnimeViewModel(get(), get()) }
    viewModel { MangaViewModel(get(), get()) }
    viewModel { HomeViewModel(get()) }
}