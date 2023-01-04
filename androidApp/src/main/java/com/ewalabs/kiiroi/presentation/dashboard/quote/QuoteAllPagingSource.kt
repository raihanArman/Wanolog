package com.ewalabs.kiiroi.presentation.dashboard.quote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.QuoteListModel
import com.ewalabs.domain.usecase.quotes.GetQuoteListUseCase
import kotlinx.coroutines.flow.last

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class QuoteAllPagingSource(
    private val useCase: GetQuoteListUseCase
): PagingSource<Int, QuoteListModel.QuoteModel>()  {
    override fun getRefreshKey(state: PagingState<Int, QuoteListModel.QuoteModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, QuoteListModel.QuoteModel> {
        val currentPage = params.key ?: 1
        return when(val response = useCase.invoke(currentPage).last()) {
            is Resource.Success -> {
                val chara = response.model?.data ?: emptyList()
                val endOfPaginationReached = chara.isEmpty()
                if (chara.isNotEmpty()) {
                    LoadResult.Page(
                        data = chara,
                        prevKey = if (currentPage == 1) null else currentPage - 1,
                        nextKey = if (endOfPaginationReached) null else currentPage + 1
                    )
                } else {
                    LoadResult.Page(
                        data = emptyList(),
                        prevKey = null,
                        nextKey = null
                    )
                }
            }
            else -> {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        }
    }
}