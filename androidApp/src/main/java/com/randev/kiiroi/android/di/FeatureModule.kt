package com.randev.kiiroi.android.di

import com.randev.kiiroi.android.presentation.MainViewModel
import com.randev.kiiroi.android.presentation.anime_all.AnimeAllViewModel
import com.randev.kiiroi.android.presentation.anime_by_category.AnimeByCategoryViewModel
import com.randev.kiiroi.android.presentation.anime_detail.DetailAnimeViewModel
import com.randev.kiiroi.android.presentation.character_anime.CharacterAnimeViewModel
import com.randev.kiiroi.android.presentation.character_detail.CharacterDetailViewModel
import com.randev.kiiroi.android.presentation.character_manga.CharacterMangaViewModel
import com.randev.kiiroi.android.presentation.comments.CommentsViewModel
import com.randev.kiiroi.android.presentation.dashboard.DashboardViewModel
import com.randev.kiiroi.android.presentation.dashboard.characters.CharacterViewModel
import com.randev.kiiroi.android.presentation.home.HomeViewModel
import com.randev.kiiroi.android.presentation.dashboard.anime.AnimeViewModel
import com.randev.kiiroi.android.presentation.dashboard.manga.MangaViewModel
import com.randev.kiiroi.android.presentation.dashboard.post.PostAllViewModel
import com.randev.kiiroi.android.presentation.dashboard.profile.ProfileViewModel
import com.randev.kiiroi.android.presentation.dashboard.quote.QuoteAllViewModel
import com.randev.kiiroi.android.presentation.dashboard.quote.QuoteDialogViewModel
import com.randev.kiiroi.android.presentation.manga_all.MangaAllViewModel
import com.randev.kiiroi.android.presentation.manga_by_category.MangaByCategoryViewModel
import com.randev.kiiroi.android.presentation.manga_detail.MangaDetailViewModel
import com.randev.kiiroi.android.presentation.review_anime.ReviewsAnimeViewModel
import com.randev.kiiroi.android.presentation.review_manga.ReviewsMangaViewModel
import com.randev.kiiroi.android.presentation.splash_screen.SplashViewModel
import com.randev.kiiroi.android.utils.SharingCommentAttr
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

val featureModule = module {
    single { SharingCommentAttr() }
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
            insertAnimeFavoriteUseCase = get(),
            deleteAnimeFavoriteUseCase = get()
        )
    }
    viewModel { params ->
        MangaDetailViewModel(
            appNavigator = get(),
            stateHandle = params.get(),
            useCase = get(),
            insertMangaFavoriteUseCase = get(),
            deleteMangaFavoriteUseCase = get()
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
    viewModel {
        ProfileViewModel(get(), get(), get(), get(), get(), get())
    }
    viewModel {
        PostAllViewModel(get(), get())
    }
    viewModel {
        CommentsViewModel(get(), get())
    }
    viewModel {
        DashboardViewModel(get())
    }
    viewModel { params ->
        AnimeByCategoryViewModel(
            navigator = get(),
            stateHandle = params.get(),
            useCase = get(),
        )
    }
    viewModel { params ->
        MangaByCategoryViewModel(
            navigator = get(),
            stateHandle = params.get(),
            useCase = get(),
        )
    }
    viewModel {
        ReviewsAnimeViewModel(get())
    }
    viewModel {
        ReviewsMangaViewModel(get())
    }
    viewModel {
        QuoteAllViewModel(get())
    }
    viewModel {
        QuoteDialogViewModel(get(), get(), get())
    }
    viewModel {
        SplashViewModel(get())
    }
}