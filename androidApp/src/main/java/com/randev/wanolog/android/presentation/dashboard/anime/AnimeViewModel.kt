package com.randev.wanolog.android.presentation.dashboard.anime

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.randev.core.wrapper.Resource
import com.randev.domain.usecase.anime.GetAnimeAllUseCase
import com.randev.domain.usecase.anime.GetAnimePopularUseCase
import com.randev.domain.usecase.anime.GetAnimeTopRatingUseCase
import com.randev.domain.usecase.anime.GetAnimeTopUpcomingUseCase
import com.randev.domain.usecase.anime.GetAnimeTrendingUseCase
import com.randev.domain.usecase.category.GetCategoryAllUseCase
import com.randev.navigation.AppNavigator
import com.randev.navigation.Destination
import com.randev.wanolog.android.presentation.home.ContentStatus
import com.randev.wanolog.android.presentation.home.ContentType
import com.randev.wanolog.android.presentation.home.HomeState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
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