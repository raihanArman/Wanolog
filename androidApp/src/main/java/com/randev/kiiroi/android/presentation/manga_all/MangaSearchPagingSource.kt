package com.randev.kiiroi.android.presentation.manga_all

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.randev.core.SortType
import com.randev.core.wrapper.Resource
import com.randev.domain.model.MangaListModel
import com.randev.domain.usecase.manga.GetMangaSearchFilterUseCase
import com.randev.domain.usecase.manga.SearchMangaRequest
import kotlinx.coroutines.flow.last

/**
 * @author Raihan Arman
 * @date 24/11/22
 */
class MangaSearchPagingSource(
    private val useCase: GetMangaSearchFilterUseCase,
    private val query: String,
    private val sortType: SortType
): PagingSource<Int, MangaListModel.MangaModel>() {
    override fun getRefreshKey(state: PagingState<Int, MangaListModel.MangaModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MangaListModel.MangaModel> {
        val currentPage = params.key ?: 0
        return when(val response = useCase.invoke(SearchMangaRequest(query, currentPage, sortType)).last()) {
            is Resource.Success -> {
                val data = response.model?.data ?: emptyList()
                val endOfPaginationReached = data.isEmpty()
                if (data.isNotEmpty()) {
                    LoadResult.Page(
                        data = data,
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