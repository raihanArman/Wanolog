package com.randev.wanolog.android.presentation.character_anime

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.randev.domain.model.CharacterListModel
import com.randev.domain.usecase.character.GetCharacterAnimeUseCase
import com.randev.domain.usecase.character.GetCharacterMangaUseCase
import com.randev.navigation.AppNavigator
import com.randev.navigation.Destination
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 28/11/22
 */
class CharacterAnimeViewModel(
    private val useCase: GetCharacterAnimeUseCase,
    private val stateHandle: SavedStateHandle,
    private val navigator: AppNavigator
): ViewModel() {
    private var animeId: String ?= null

    val characterPagination: Flow<PagingData<CharacterListModel.CharacterModel>> = Pager(PagingConfig(pageSize = 20)) {
        animeId = stateHandle.get<String>(Destination.CharacterAnimeScreen.ANIME_ID_KEY) ?: ""
        CharacterAnimePagingSource(useCase, animeId ?: "1")
    }.flow.cachedIn(viewModelScope)

    fun onBackScreen() {
        navigator.tryNavigateBack()
    }

}