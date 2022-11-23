package com.randev.wanolog.android.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.randev.core.wrapper.Resource
import com.randev.domain.usecase.category.GetCategoryAllUseCase
import com.randev.wanolog.android.presentation.home.ContentType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
class HomeViewModel(
    private val categoryAllUseCase: GetCategoryAllUseCase
): ViewModel() {

    var contentTypeState by mutableStateOf(ContentType.MANGA)

    private val _observeCategory: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val observeCategory: StateFlow<HomeState> = _observeCategory

    fun changeContentType(contentType: ContentType) {
        contentTypeState = contentType
    }

    fun getCategory() {
        viewModelScope.launch {
            categoryAllUseCase.invoke().collect { response ->
                when(response) {
                    is Resource.Success -> {
                        _observeCategory.update {
                            it.copy(
                                categoryData = response.model?.data,
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _observeCategory.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                    }
                    is Resource.Error -> {
                        _observeCategory.update {
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