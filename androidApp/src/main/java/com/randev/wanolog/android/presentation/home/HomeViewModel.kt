package com.randev.wanolog.android.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeListModel
import com.randev.domain.usecase.GetAnimeAllUseCase
import com.randev.domain.usecase.GetAnimeTrendingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

class HomeViewModel(
    private val allUseCase: GetAnimeAllUseCase,
    private val trendingUseCase: GetAnimeTrendingUseCase
): ViewModel() {

    private val _observeHome: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val observeHome: StateFlow<HomeState> = _observeHome

    fun getHome() {
        viewModelScope.launch {
            combine(
                allUseCase.invoke(),
                trendingUseCase.invoke()
            ) { all, trending ->
                if (all is Resource.Success && trending is Resource.Success) {
                    _observeHome.update {
                        it.copy(
                            allData = all.model?.data,
                            trendingData = trending.model?.data,
                            isLoading = false
                        )
                    }
                } else if (all is Resource.Error) {
                    _observeHome.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = all.errorMessage
                        )
                    }
                } else if (trending is Resource.Error) {
                    _observeHome.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = trending.errorMessage
                        )
                    }
                } else {
                    _observeHome.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }
            }.stateIn(viewModelScope, SharingStarted.Eagerly, null)

        }
    }

}