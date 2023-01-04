package com.ewalabs.kiiroi.presentation.anime_detail

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.AnimeDetailModel
import com.ewalabs.domain.model.CategoryModel
import com.ewalabs.domain.usecase.anime.GetAnimeDetailUseCase
import com.ewalabs.domain.usecase.anime_favorite.AnimeFavoriteParams
import com.ewalabs.domain.usecase.anime_favorite.DeleteAnimeFavoriteUseCase
import com.ewalabs.domain.usecase.anime_favorite.InsertAnimeFavoriteUseCase
import com.ewalabs.navigation.AppNavigator
import com.ewalabs.navigation.Destination
import com.ewalabs.kiiroi.utils.SheetHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 26/11/22
 */
class DetailAnimeViewModel(
    private val useCase: GetAnimeDetailUseCase,
    private val deleteAnimeFavoriteUseCase: DeleteAnimeFavoriteUseCase,
    private val insertAnimeFavoriteUseCase: InsertAnimeFavoriteUseCase,
    private val appNavigator: AppNavigator,
    private val stateHandle: SavedStateHandle,
): ViewModel() {
    var animeId: String ?= null

    var isFavorite by mutableStateOf(false)

    @OptIn(ExperimentalMaterialApi::class)
    val sheetHandler = SheetHandler(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
        confirmStateChange = {
            true
        }
    )

    private val _observeDetailState: MutableStateFlow<DetailAnimeState> = MutableStateFlow(
        DetailAnimeState()
    )
    val observeDetailState = _observeDetailState.asStateFlow()

    init {
        animeId = stateHandle.get<String>(Destination.AnimeDetailScreen.ANIME_ID_KEY) ?: ""
        println("ANIME ID -> $animeId")
        animeId?.let {
            getAnimeDetail(it)
        }
    }

    fun insertDeleteFavorite(data: AnimeDetailModel) {
        viewModelScope.launch {
            if(isFavorite) {
                deleteAnimeFavoriteUseCase.invoke(data.data.id.toInt()).collectLatest {
                    isFavorite = false
                }
            }else {
                insertAnimeFavoriteUseCase.invoke(
                    AnimeFavoriteParams(
                        id = data.data.id.toLong(),
                        title = data.data.attributes.titles.enJp,
                        poster = data.data.attributes.posterImage.original,
                        rate = data.data.attributes.averageRating
                    )
                ).collectLatest {
                    isFavorite = true
                }
            }
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

                            isFavorite = resource.model?.isFavorite ?: false
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

    @OptIn(ExperimentalMaterialApi::class)
    fun openReviewBottomSheet() {
        sheetHandler.state {
            show()
        }
    }

}