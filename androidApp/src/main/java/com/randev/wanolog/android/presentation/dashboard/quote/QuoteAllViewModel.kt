package com.randev.wanolog.android.presentation.dashboard.quote

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.randev.domain.model.AnimeDetailModel
import com.randev.domain.model.PostListModel
import com.randev.domain.model.QuoteListModel
import com.randev.domain.usecase.anime_favorite.AnimeFavoriteParams
import com.randev.domain.usecase.quote_favorite.DeleteQuoteFavoriteUseCase
import com.randev.domain.usecase.quote_favorite.InsertQuoteFavoriteUseCase
import com.randev.domain.usecase.quote_favorite.QuoteFavoriteParams
import com.randev.domain.usecase.quotes.GetQuoteListUseCase
import com.randev.wanolog.android.presentation.dashboard.post.PostPagingSource
import com.randev.wanolog.android.presentation.dashboard.profile.ProfileViewModel
import com.randev.wanolog.android.utils.IntentUtils
import com.randev.wanolog.android.utils.bitmapToCacheUri
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
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