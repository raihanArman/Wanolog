package com.randev.wanolog.android.presentation.anime_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.randev.core.wrapper.Resource
import com.randev.domain.model.CategoryModel
import com.randev.domain.usecase.anime.GetAnimeDetailUseCase
import com.randev.navigation.AppNavigator
import com.randev.navigation.Destination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 26/11/22
 */
class DetailAnimeViewModel(
    private val useCase: GetAnimeDetailUseCase,
    private val appNavigator: AppNavigator,
    private val stateHandle: SavedStateHandle,
): ViewModel() {
    private var animeId: String ?= null

    private val _observeDetailState: MutableStateFlow<DetailAnimeState> = MutableStateFlow(DetailAnimeState())
    val observeDetailState = _observeDetailState.asStateFlow()

    init {
        animeId = stateHandle.get<String>(Destination.AnimeDetailScreen.ANIME_ID_KEY) ?: ""
        println("ANIME ID -> $animeId")
        animeId?.let {
            getAnimeDetail(it)
        }
    }

    private fun getAnimeDetail(id: String) {
        viewModelScope.launch {
            try {
                useCase.invoke(id).collect { resource ->
                    when(resource) {
                        is Resource.Loading -> {
                            _observeDetailState.update {
                                it.copy(
                                    isLoading = true
                                )
                            }
                        }
                        is Resource.Success -> {
                            println("Detail Review -> ${resource.model?.reviews}")
                            _observeDetailState.update {
                                it.copy(
                                    isLoading = false,
                                    data = resource.model
                                )
                            }
                        }
                        is Resource.Error -> {
                            println("Error -> ${resource.errorMessage}")
                            _observeDetailState.update {
                                it.copy(
                                    isLoading = false,
                                    errorMessage = resource.errorMessage
                                )
                            }
                        }
                        else -> {}
                    }
                }
            }catch (e: Exception) {
                println("Error Exception -> $e")
            }
        }
    }

    fun onBackScreen() {
        appNavigator.tryNavigateBack()
    }

    fun onNavigateToCharactersClicked() {
        println("Character Manga Clicked")
        animeId?.let {
            appNavigator.tryNavigateTo(
                Destination.CharacterAnimeScreen(
                    id = it
                )
            )
        }
    }

    fun onNavigateToDetailsClicked(id: String) {
        appNavigator.tryNavigateTo(
            Destination.AnimeDetailScreen(
                id = id
            )
        )
    }

    fun onNavigateToAnimeByCategoryClicked(categoryModel: CategoryModel) {
        appNavigator.tryNavigateTo(
            Destination.AnimeByCategoryScreen(
                id = categoryModel.id,
                name = categoryModel.title
            )
        )
    }

}