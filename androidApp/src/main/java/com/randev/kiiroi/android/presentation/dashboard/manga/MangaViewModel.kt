package com.randev.kiiroi.android.presentation.dashboard.manga

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.randev.core.wrapper.Resource
import com.randev.domain.usecase.manga.GetMangaPopularUseCase
import com.randev.domain.usecase.manga.GetMangaTopRatingUseCase
import com.randev.domain.usecase.manga.GetMangaTopUpcomingUseCase
import com.randev.domain.usecase.manga.GetMangaTrendingUseCase
import com.randev.navigation.AppNavigator
import com.randev.navigation.Destination
import com.randev.kiiroi.android.presentation.home.ContentStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
class MangaViewModel(
    private val trendingUseCase: GetMangaTrendingUseCase,
    private val upcomingUseCase: GetMangaTopUpcomingUseCase,
    private val ratingUseCase: GetMangaTopRatingUseCase,
    private val popularUseCase: GetMangaPopularUseCase,
    private val appNavigator: AppNavigator
): ViewModel() {

    private val _observeManga: MutableStateFlow<MangaState> = MutableStateFlow(MangaState())
    val observeManga: StateFlow<MangaState> = _observeManga

    var contentStatusState by mutableStateOf(ContentStatus.TRENDING)

    init {
        changeContentContentStatus(ContentStatus.TRENDING)
    }

    fun changeContentContentStatus(contentStatus: ContentStatus) {
        contentStatusState = contentStatus
        when(contentStatus) {
            ContentStatus.TRENDING -> {
                getTrending()
            }
            ContentStatus.TOP_UPCOMING -> {
                getTopUpcoming()
            }
            ContentStatus.TOP_RATING -> {
                getTopRating()
            }
            ContentStatus.POPULAR -> {
                getTopPopular()
            }
        }
    }

    private fun getTrending(){
        viewModelScope.launch {
            trendingUseCase.invoke().collect { resource ->
                when(resource) {
                    is Resource.Success -> {
                        _observeManga.update {
                            it.copy(
                                trendingData = resource.model?.data,
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Error -> {
                        _observeManga.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = resource.errorMessage
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _observeManga.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    private fun getTopUpcoming() {
        viewModelScope.launch {
            upcomingUseCase.invoke().collect { resource ->
                when(resource) {
                    is Resource.Success -> {
                        _observeManga.update {
                            it.copy(
                                topUpcomingData = resource.model?.data,
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Error -> {
                        _observeManga.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = resource.errorMessage
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _observeManga.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    private fun getTopRating() {
        viewModelScope.launch {
            ratingUseCase.invoke().collect { resource ->
                when(resource) {
                    is Resource.Success -> {
                        _observeManga.update {
                            it.copy(
                                topRatingData = resource.model?.data,
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Error -> {
                        _observeManga.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = resource.errorMessage
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _observeManga.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    private fun getTopPopular() {
        viewModelScope.launch {
            popularUseCase.invoke().collect { resource ->
                when(resource) {
                    is Resource.Success -> {
                        _observeManga.update {
                            it.copy(
                                popularData = resource.model?.data,
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Error -> {
                        _observeManga.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = resource.errorMessage
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _observeManga.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    fun onNavigateToDetailsClicked(id: String) {
        appNavigator.tryNavigateTo(
            Destination.MangaDetailScreen(
                id = id
            )
        )
    }

    fun onNavigateToMangaAll() {
        appNavigator.tryNavigateTo(Destination.MangaAllScreen.fullRoute)
    }

}