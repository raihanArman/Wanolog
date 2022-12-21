package com.randev.wanolog.android.presentation.dashboard.anime

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.randev.core.wrapper.Resource
import com.randev.domain.usecase.anime.GetAnimePopularUseCase
import com.randev.domain.usecase.anime.GetAnimeTopRatingUseCase
import com.randev.domain.usecase.anime.GetAnimeTopUpcomingUseCase
import com.randev.domain.usecase.anime.GetAnimeTrendingUseCase
import com.randev.navigation.AppNavigator
import com.randev.navigation.Destination
import com.randev.wanolog.android.presentation.home.ContentStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

class AnimeViewModel(
    private val trendingUseCase: GetAnimeTrendingUseCase,
    private val topUpcomingUseCase: GetAnimeTopUpcomingUseCase,
    private val topRatingUseCase: GetAnimeTopRatingUseCase,
    private val popularUseCase: GetAnimePopularUseCase,
    private val appNavigator: AppNavigator
): ViewModel() {

    private val _observeHome: MutableStateFlow<AnimeState> = MutableStateFlow(AnimeState())
    val observeHome: StateFlow<AnimeState> = _observeHome

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
                        _observeHome.update {
                            it.copy(
                                trendingData = resource.model?.data,
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Error -> {
                        _observeHome.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = resource.errorMessage
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _observeHome.update {
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
            topUpcomingUseCase.invoke().collect { resource ->
                when(resource) {
                    is Resource.Success -> {
                        _observeHome.update {
                            it.copy(
                                topUpcomingData = resource.model?.data,
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Error -> {
                        _observeHome.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = resource.errorMessage
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _observeHome.update {
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
            topRatingUseCase.invoke().collect { resource ->
                when(resource) {
                    is Resource.Success -> {
                        _observeHome.update {
                            it.copy(
                                topRatingData = resource.model?.data,
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Error -> {
                        _observeHome.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = resource.errorMessage
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _observeHome.update {
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
                        _observeHome.update {
                            it.copy(
                                popularData = resource.model?.data,
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Error -> {
                        _observeHome.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = resource.errorMessage
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _observeHome.update {
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

    fun onNavigateToAnimeAll() {
        appNavigator.tryNavigateTo(Destination.AnimeAllScreen.fullRoute)
    }

    fun onNavigateToDetailsClicked(id: String) {
        appNavigator.tryNavigateTo(
            Destination.AnimeDetailScreen(
                id = id
            )
        )
    }

//    fun getHome() {
//        viewModelScope.launch {
//            combine(
//                allUseCase.invoke(),
//                trendingUseCase.invoke(),
//            ) { all, trending ->
//                if (all is Resource.Success && trending is Resource.Success) {
//                    _observeHome.update {
//                        it.copy(
//                            allData = all.model?.data,
//                            trendingData = trending.model?.data,
//                            isLoading = false
//                        )
//                    }
//                } else if (all is Resource.Error) {
//                    println("Error All -> ${all.errorMessage}")
//                    _observeHome.update {
//                        it.copy(
//                            isLoading = false,
//                            errorMessage = all.errorMessage
//                        )
//                    }
//                } else if (trending is Resource.Error) {
//                    _observeHome.update {
//                        it.copy(
//                            isLoading = false,
//                            errorMessage = trending.errorMessage
//                        )
//                    }
//                } else {
//                    _observeHome.update {
//                        it.copy(
//                            isLoading = true
//                        )
//                    }
//                }
//            }.stateIn(viewModelScope, SharingStarted.Eagerly, null)
//        }
//    }

}