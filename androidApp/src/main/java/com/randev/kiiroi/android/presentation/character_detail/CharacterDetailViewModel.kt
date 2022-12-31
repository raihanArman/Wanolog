package com.randev.kiiroi.android.presentation.character_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.randev.core.wrapper.Resource
import com.randev.domain.usecase.character.GetCharacterDetailUseCase
import com.randev.navigation.AppNavigator
import com.randev.navigation.Destination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 28/11/22
 */
class CharacterDetailViewModel(
    private val useCase: GetCharacterDetailUseCase,
    private val appNavigator: AppNavigator,
    private val stateHandle: SavedStateHandle,
): ViewModel() {

    private val _observeCharDetail: MutableStateFlow<CharacterDetailState> = MutableStateFlow(CharacterDetailState())
    val observeCharDetail = _observeCharDetail.asStateFlow()

    private var charId: String ?= null

    init {
        charId = stateHandle.get<String>(Destination.CharacterDetailScreen.CHARACTER_ID_KEY) ?: ""
        println("CHARACTER ID -> $charId")
        charId?.let {
            getCharacterDetail(it)
        }
    }

    private fun getCharacterDetail(it: String) {
        viewModelScope.launch {
            useCase.invoke(it).collect { resource ->
                when(resource) {
                    is Resource.Loading -> {
                        _observeCharDetail.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                    }
                    is Resource.Success -> {
                        _observeCharDetail.update {
                            it.copy(
                                isLoading = false,
                                data = resource.model
                            )
                        }
                    }
                    is Resource.Error -> {
                        _observeCharDetail.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = resource.errorMessage
                            )
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    fun onBackScreen() {
        appNavigator.tryNavigateBack()
    }

}