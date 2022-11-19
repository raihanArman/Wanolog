package com.randev.wanolog.android.presentation.home.manga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.randev.core.wrapper.Resource
import com.randev.domain.usecase.manga.GetMangaAllUseCase
import com.randev.domain.usecase.manga.GetMangaTrendingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
class MangaViewModel(
    private val allUseCase: GetMangaAllUseCase,
    private val trendingUseCase: GetMangaTrendingUseCase,
): ViewModel() {

    private val _observeManga: MutableStateFlow<MangaState> = MutableStateFlow(MangaState())
    val observeManga: StateFlow<MangaState> = _observeManga

    fun getManga() {
        viewModelScope.launch {
            combine(
                allUseCase.invoke(),
                trendingUseCase.invoke(),
            ) { all, trending ->
                if (all is Resource.Success && trending is Resource.Success) {
                    _observeManga.update {
                        it.copy(
                            allData = all.model?.data,
                            trendingData = trending.model?.data,
                            isLoading = false
                        )
                    }
                } else if (all is Resource.Error) {
                    println("Error All -> ${all.errorMessage}")
                    _observeManga.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = all.errorMessage
                        )
                    }
                } else if (trending is Resource.Error) {
                    _observeManga.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = trending.errorMessage
                        )
                    }
                }  else {
                    _observeManga.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }
            }.stateIn(viewModelScope, SharingStarted.Eagerly, null)

        }
    }

}