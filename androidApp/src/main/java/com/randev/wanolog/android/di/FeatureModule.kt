package com.randev.wanolog.android.di

import com.randev.wanolog.android.presentation.MainViewModel
import com.randev.wanolog.android.presentation.anime_all.AnimeAllViewModel
import com.randev.wanolog.android.presentation.anime_detail.DetailAnimeViewModel
import com.randev.wanolog.android.presentation.character_anime.CharacterAnimeViewModel
import com.randev.wanolog.android.presentation.character_detail.CharacterDetailViewModel
import com.randev.wanolog.android.presentation.character_manga.CharacterMangaViewModel
import com.randev.wanolog.android.presentation.dashboard.characters.CharacterViewModel
import com.randev.wanolog.android.presentation.home.HomeViewModel
import com.randev.wanolog.android.presentation.dashboard.anime.AnimeViewModel
import com.randev.wanolog.android.presentation.dashboard.manga.MangaViewModel
import com.randev.wanolog.android.presentation.manga_all.MangaAllViewModel
import com.randev.wanolog.android.presentation.manga_detail.MangaDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

val featureModule = module {
    viewModel { AnimeViewModel(get(), get(), get(), get(), get()) }
    viewModel { MangaViewModel(get(), get(), get(), get(), get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { CharacterViewModel(get()) }
    viewModel { AnimeAllViewModel(get(), get(), get()) }
    viewModel { MangaAllViewModel(get(), get(), get()) }
    viewModel { MainViewModel(get()) }
    viewModel { params ->
        DetailAnimeViewModel(
            appNavigator = get(),
            stateHandle = params.get(),
            useCase = get(),
        )
    }
    viewModel { params ->
        MangaDetailViewModel(
            appNavigator = get(),
            stateHandle = params.get(),
            useCase = get(),
        )
    }
    viewModel { params ->
        CharacterMangaViewModel(
            navigator = get(),
            stateHandle = params.get(),
            useCase = get(),
        )
    }
    viewModel { params ->
        CharacterAnimeViewModel(
            navigator = get(),
            stateHandle = params.get(),
            useCase = get(),
        )
    }
    viewModel { params ->
        CharacterDetailViewModel(
            appNavigator = get(),
            stateHandle = params.get(),
            useCase = get(),
        )
    }
}