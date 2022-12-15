package com.randev.wanolog.android.presentation.manga_detail

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.randev.core.wrapper.Resource
import com.randev.domain.model.CategoryModel
import com.randev.domain.usecase.manga.GetMangaDetailUseCase
import com.randev.navigation.AppNavigator
import com.randev.navigation.Destination
import com.randev.wanolog.android.presentation.anime_detail.DetailAnimeState
import com.randev.wanolog.android.utils.SheetHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
class MangaDetailViewModel(
    private val useCase: GetMangaDetailUseCase,
    private val appNavigator: AppNavigator,
    private val stateHandle: SavedStateHandle,
): ViewModel() {
    var mangaId: String ?= null

    @OptIn(ExperimentalMaterialApi::class)
    val sheetHandler = SheetHandler(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
        confirmStateChange = {
            true
        }
    )

    private val _observeDetailState: MutableStateFlow<MangaDetailState> = MutableStateFlow(
        MangaDetailState()
    )
    val observeDetailState = _observeDetailState.asStateFlow()

    init {
        mangaId = stateHandle.get<String>(Destination.MangaDetailScreen.MANGA_ID_KEY) ?: ""
        println("Manga ID -> $mangaId")
        mangaId?.let {
            getMangaDetail(it)
        }
    }

    private fun getMangaDetail(id: String) {
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

    fun onNavigateToCharactersClicked() {
        println("Character Manga Clicked")
        mangaId?.let {
            appNavigator.tryNavigateTo(
                Destination.CharacterMangaScreen(
                    id = it
                )
            )
        }
    }

    fun onNavigateToMangaByCategoryClicked(categoryModel: CategoryModel) {
        appNavigator.tryNavigateTo(
            Destination.MangaByCategoryScreen(
                id = categoryModel.id,
                name = categoryModel.title
            )
        )
    }

    fun onBackScreen() {
        appNavigator.tryNavigateBack()
    }

    fun onNavigateToDetailsClicked(id: String) {
        appNavigator.tryNavigateTo(
            Destination.AnimeDetailScreen(
                id = id
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