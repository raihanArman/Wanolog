package com.ewalabs.kiiroi.presentation.anime_all

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ewalabs.domain.model.AnimeListModel
import com.ewalabs.domain.usecase.anime.GetAnimeAllUseCase
import com.ewalabs.domain.usecase.anime.GetAnimeSearchFilterUseCase
import com.ewalabs.kiiroi.utils.SheetHandler
import com.ewalabs.core.SortType
import com.ewalabs.navigation.AppNavigator
import com.ewalabs.navigation.Destination
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.launch
import java.util.*

/**
 * @author Raihan Arman
 * @date 23/11/22
 */

@OptIn(ExperimentalCoroutinesApi::class)
class AnimeAllViewModel(
    private val useCase: GetAnimeSearchFilterUseCase,
    private val useCaseAll: GetAnimeAllUseCase,
    private val navigator: AppNavigator
): ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _sortTypeFlow = MutableStateFlow(SortType.NA)
    val sortTypeFlow = _sortTypeFlow.asStateFlow()

    @OptIn(ExperimentalMaterialApi::class)
    val sheetHandler = SheetHandler(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
        confirmStateChange = {
            true
        }
    )

    @OptIn(FlowPreview::class)
    val searchFlow = _searchQuery
        .debounce(1000)
        .map {
            it.trim().lowercase(Locale.ROOT)
        }
        .filter {
            it.isNotEmpty()
        }
        .distinctUntilChanged()

    private val searchCombineFlow = combine(
        searchFlow,
        _sortTypeFlow,
        ::Pair
    ).flatMapLatest {
        getDataSearch(query = it.first, sortType = it.second)
    }

    val searchFilterFlow = merge(
        searchCombineFlow,
        getDataAll()
    ).cachedIn(viewModelScope)

    private fun getDataSearch(query: String, sortType: SortType): Flow<PagingData<AnimeListModel.AnimeModel>> {
        return Pager(PagingConfig(pageSize = 20)) {
            AnimeSearchPagingSource(useCase, query, sortType)
        }.flow
    }

    private fun getDataAll(): Flow<PagingData<AnimeListModel.AnimeModel>> {
        return Pager(PagingConfig(pageSize = 20)) {
            AnimeAllPagingSource(useCaseAll)
        }.flow
    }


    fun updateSearchQuery(query: String){
        _searchQuery.value = query
    }

    @OptIn(ExperimentalMaterialApi::class)
    fun onShowBottomDialog() {
        sheetHandler.state {
            show()
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    fun onHideBottomDialog() {
        sheetHandler.state {
            hide()
        }
    }

    fun onApplySortType(sortType: SortType) {
        viewModelScope.launch {
            _sortTypeFlow.value = sortType
            onHideBottomDialog()
        }
    }

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