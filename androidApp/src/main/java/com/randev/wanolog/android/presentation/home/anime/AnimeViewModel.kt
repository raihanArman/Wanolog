package com.randev.wanolog.android.presentation.home.anime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.randev.core.wrapper.Resource
import com.randev.domain.usecase.anime.GetAnimeAllUseCase
import com.randev.domain.usecase.anime.GetAnimeTrendingUseCase
import com.randev.domain.usecase.category.GetCategoryAllUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

class AnimeViewModel(
    private val allUseCase: GetAnimeAllUseCase,
    private val trendingUseCase: GetAnimeTrendingUseCase,
): ViewModel() {

    private val _observeHome: MutableStateFlow<AnimeState> = MutableStateFlow(AnimeState())
    val observeHome: StateFlow<AnimeState> = _observeHome

    fun getHome() {
        viewModelScope.launch {
            combine(
                allUseCase.invoke(),
                trendingUseCase.invoke(),
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
                    println("Error All -> ${all.errorMessage}")
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