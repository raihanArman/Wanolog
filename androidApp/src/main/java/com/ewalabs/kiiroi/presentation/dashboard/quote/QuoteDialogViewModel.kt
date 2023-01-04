package com.ewalabs.kiiroi.presentation.dashboard.quote

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.QuoteListModel
import com.ewalabs.domain.usecase.quote_favorite.DeleteQuoteFavoriteUseCase
import com.ewalabs.domain.usecase.quote_favorite.InsertQuoteFavoriteUseCase
import com.ewalabs.domain.usecase.quote_favorite.IsQuoteFavoriteUseCase
import com.ewalabs.domain.usecase.quote_favorite.QuoteFavoriteParams
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 26/12/22
 */
class QuoteDialogViewModel(
    private val insertQuoteFavoriteUseCase: InsertQuoteFavoriteUseCase,
    private val deleteQuoteFavoriteUseCase: DeleteQuoteFavoriteUseCase,
    private val isFavoriteUseCase: IsQuoteFavoriteUseCase
): ViewModel() {

    var isFavorite by mutableStateOf(false)

    fun checkQuoteFavorite(data: QuoteListModel.QuoteModel) {
        viewModelScope.launch {
            isFavoriteUseCase(data.quote).collectLatest { resource ->
                when (resource) {
                    is Resource.Success -> {
                        isFavorite = resource.model!!
                    }
                    else -> {}
                }
            }
        }
    }

    fun insertDeleteFavorite(data: QuoteListModel.QuoteModel) {
        viewModelScope.launch {
            if(isFavorite) {
                deleteQuoteFavoriteUseCase.invoke(data.quote).collectLatest {
                    isFavorite = false
                }
            }else {
                insertQuoteFavoriteUseCase.invoke(
                    QuoteFavoriteParams(
                        quote = data.quote,
                        anime = data.anime,
                        character = data.character,
                        backgroundColor = data.backgroundColor.toString()
                    )
                ).collectLatest {
                    isFavorite = true
                }
            }
        }
    }
}