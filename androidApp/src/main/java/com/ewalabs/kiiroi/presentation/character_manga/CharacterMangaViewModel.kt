package com.ewalabs.kiiroi.presentation.character_manga

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ewalabs.domain.model.CharacterListModel
import com.ewalabs.domain.usecase.character.GetCharacterMangaUseCase
import com.ewalabs.navigation.AppNavigator
import com.ewalabs.navigation.Destination
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 28/11/22
 */
class CharacterMangaViewModel(
    private val useCase: GetCharacterMangaUseCase,
    private val stateHandle: SavedStateHandle,
    private val navigator: AppNavigator
): ViewModel() {
    private var mangaId: String ?= null

    val characterPagination: Flow<PagingData<CharacterListModel.CharacterModel>> = Pager(PagingConfig(pageSize = 20)) {
        mangaId = stateHandle.get<String>(Destination.CharacterMangaScreen.MANGA_ID_KEY) ?: ""
        CharacterMangaPagingSource(useCase, mangaId ?: "1")
    }.flow.cachedIn(viewModelScope)

    fun onBackScreen() {
        navigator.tryNavigateBack()
    }

    fun onNavigateToDetailsClicked(id: String) {
        navigator.tryNavigateTo(
            Destination.CharacterDetailScreen(
                id = id
            )
        )
    }

}