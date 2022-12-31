package com.randev.kiiroi.android.presentation.dashboard.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.randev.core.wrapper.Resource
import com.randev.domain.model.CharacterListModel
import com.randev.domain.usecase.character.GetCharacterAllUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
class CharacterViewModel(
    private val useCase: GetCharacterAllUseCase
): ViewModel() {

    private val _observeCharacter: MutableStateFlow<CharacterState> = MutableStateFlow(CharacterState())
    val observeCharacter = _observeCharacter.asStateFlow()

    val charaPagination: Flow<PagingData<CharacterListModel.CharacterModel>> = Pager(PagingConfig(pageSize = 20)) {
        CharacterPagingSource(useCase)
    }.flow.cachedIn(viewModelScope)

    fun getCharacters(){
        viewModelScope.launch {
            useCase.invoke().collect { response ->
                when(response) {
                    is Resource.Loading -> {
                        _observeCharacter.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                    }
                    is Resource.Success -> {
                        _observeCharacter.update {
                            it.copy(
                                isLoading = false,
                                data = response.model?.data
                            )
                        }
                    }
                    is Resource.Error -> {
                        _observeCharacter.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = response.errorMessage
                            )
                        }
                    }
                    else -> {}
                }
            }
        }
    }

}