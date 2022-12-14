package com.ewalabs.kiiroi.presentation.dashboard.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ewalabs.domain.model.QuoteListModel
import com.ewalabs.domain.usecase.quotes.GetQuoteListUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class QuoteAllViewModel(
    private val useCase: GetQuoteListUseCase,
): ViewModel() {
    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    val quotePagination: Flow<PagingData<QuoteListModel.QuoteModel>> = Pager(PagingConfig(pageSize = 20)) {
        QuoteAllPagingSource(useCase)
    }.flow.cachedIn(viewModelScope)

    fun clickQuote(quote: QuoteListModel.QuoteModel) {
        viewModelScope.launch {
            _eventFlow.emit(UIEvent.ShowDialog(quote))
        }
    }

    sealed class UIEvent{
        data class ShowDialog(val quote: QuoteListModel.QuoteModel): UIEvent()
        data class NoEvent(val dd: String): UIEvent()
    }

}