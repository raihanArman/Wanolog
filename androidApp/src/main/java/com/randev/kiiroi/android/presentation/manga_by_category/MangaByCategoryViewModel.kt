package com.randev.kiiroi.android.presentation.manga_by_category

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
import com.randev.domain.model.MangaListModel
import com.randev.domain.usecase.manga.GetMangaByCategoryUseCase
import com.randev.navigation.AppNavigator
import com.randev.navigation.Destination
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 13/12/22
 */
class MangaByCategoryViewModel(
    private val useCase: GetMangaByCategoryUseCase,
    private val stateHandle: SavedStateHandle,
    private val navigator: AppNavigator
): ViewModel() {
    private var categoryId: String ?= null
    var categoryName by mutableStateOf("")

    val mangaPagination: Flow<PagingData<MangaListModel.MangaModel>> = Pager(
        PagingConfig(pageSize = 20)
    ) {
        categoryId = stateHandle.get<String>(Destination.MangaByCategoryScreen.CATEGORY_ID_KEY) ?: ""
        categoryName = stateHandle.get<String>(Destination.MangaByCategoryScreen.CATEGORY_NAME_KEY) ?: ""
        MangaByCategoryPagingSource(useCase, categoryId = categoryId ?: "1")
    }.flow.cachedIn(viewModelScope)

    fun onBackScreen() {
        navigator.tryNavigateBack()
    }

    fun onNavigateToDetailsClicked(id: String) {
        navigator.tryNavigateTo(
            Destination.MangaDetailScreen(
                id = id
            )
        )
    }

}