package com.ewalabs.kiiroi.di

import com.ewalabs.kiiroi.presentation.MainViewModel
import com.ewalabs.kiiroi.presentation.anime_all.AnimeAllViewModel
import com.ewalabs.kiiroi.presentation.anime_by_category.AnimeByCategoryViewModel
import com.ewalabs.kiiroi.presentation.anime_detail.DetailAnimeViewModel
import com.ewalabs.kiiroi.presentation.character_anime.CharacterAnimeViewModel
import com.ewalabs.kiiroi.presentation.character_detail.CharacterDetailViewModel
import com.ewalabs.kiiroi.presentation.character_manga.CharacterMangaViewModel
import com.ewalabs.kiiroi.presentation.comments.CommentsViewModel
import com.ewalabs.kiiroi.presentation.dashboard.DashboardViewModel
import com.ewalabs.kiiroi.presentation.dashboard.characters.CharacterViewModel
import com.ewalabs.kiiroi.presentation.home.HomeViewModel
import com.ewalabs.kiiroi.presentation.dashboard.anime.AnimeViewModel
import com.ewalabs.kiiroi.presentation.dashboard.manga.MangaViewModel
import com.ewalabs.kiiroi.presentation.dashboard.post.PostAllViewModel
import com.ewalabs.kiiroi.presentation.dashboard.profile.ProfileViewModel
import com.ewalabs.kiiroi.presentation.dashboard.quote.QuoteAllViewModel
import com.ewalabs.kiiroi.presentation.dashboard.quote.QuoteDialogViewModel
import com.ewalabs.kiiroi.presentation.manga_all.MangaAllViewModel
import com.ewalabs.kiiroi.presentation.manga_by_category.MangaByCategoryViewModel
import com.ewalabs.kiiroi.presentation.manga_detail.MangaDetailViewModel
import com.ewalabs.kiiroi.presentation.review_anime.ReviewsAnimeViewModel
import com.ewalabs.kiiroi.presentation.review_manga.ReviewsMangaViewModel
import com.ewalabs.kiiroi.presentation.splash_screen.SplashViewModel
import com.ewalabs.kiiroi.utils.SharingCommentAttr
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

val featureModule = module {
    single { SharingCommentAttr() }
    viewModel { AnimeViewModel(get(), get(), get(), get(), get(), get()) }
    viewModel { MangaViewModel(get(), get(), get(), get(), get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { CharacterViewModel(get()) }
    viewModel { AnimeAllViewModel(get(), get(), get()) }
    viewModel { MangaAllViewModel(get(), get(), get()) }
    viewModel { MainViewModel(get(), get()) }
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
        DashboardViewModel(get(), get())
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