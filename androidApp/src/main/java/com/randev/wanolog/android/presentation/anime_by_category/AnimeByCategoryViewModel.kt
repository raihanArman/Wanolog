package com.randev.wanolog.android.presentation.anime_by_category

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.randev.domain.model.AnimeListModel
import com.randev.domain.usecase.anime.GetAnimeByCategoryUseCase
import com.randev.navigation.AppNavigator
import com.randev.navigation.Destination
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 13/12/22
 */
class AnimeByCategoryViewModel(
    private val useCase: GetAnimeByCategoryUseCase,
    private val stateHandle: SavedStateHandle,
    private val navigator: AppNavigator
): ViewModel() {
    private var categoryId: String ?= null
    var categoryName by mutableStateOf("")

    val animePagination: Flow<PagingData<AnimeListModel.AnimeModel>> = Pager(
        PagingConfig(pageSize = 20)
    ) {
        categoryId = stateHandle.get<String>(Destination.AnimeByCategoryScreen.CATEGORY_ID_KEY) ?: ""
        categoryName = stateHandle.get<String>(Destination.AnimeByCategoryScreen.CATEGORY_NAME_KEY) ?: ""
        AnimeByCategoryPagingSource(useCase, categoryId = categoryId ?: "1")
    }.flow.cachedIn(viewModelScope)

    fun onBackScreen() {
        navigator.tryNavigateBack()
    }

    fun onNavigateToDetailsClicked(id: String) {
        navigator.tryNavigateTo(
            Destination.AnimeDetailScreen(
                id = id
            )
        )
    }

}