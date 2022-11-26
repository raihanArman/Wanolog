package com.randev.wanolog.android.presentation.anime_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.randev.domain.usecase.anime.GetAnimeDetailUseCase
import com.randev.navigation.AppNavigator
import com.randev.navigation.Destination

/**
 * @author Raihan Arman
 * @date 26/11/22
 */
class DetailAnimeViewModel(
    private val useCase: GetAnimeDetailUseCase,
    private val appNavigator: AppNavigator,
    private val stateHandle: SavedStateHandle,
): ViewModel() {
    private var animeId: String ?= null

    init {
        animeId = stateHandle.get<String>(Destination.AnimeDetailScreen.ANIME_ID_KEY) ?: ""
        println("ANIME ID -> $animeId")
    }

}