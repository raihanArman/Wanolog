package com.randev.wanolog.android.presentation.dashboard.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.randev.domain.model.PostListModel
import com.randev.domain.model.QuoteListModel
import com.randev.domain.usecase.quotes.GetQuoteListUseCase
import com.randev.wanolog.android.presentation.dashboard.post.PostPagingSource
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class QuoteAllViewModel(
    private val useCase: GetQuoteListUseCase
): ViewModel() {

    val quotePagination: Flow<PagingData<QuoteListModel.QuoteModel>> = Pager(PagingConfig(pageSize = 20)) {
        QuoteAllPagingSource(useCase)
    }.flow.cachedIn(viewModelScope)

}