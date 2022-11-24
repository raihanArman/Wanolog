package com.randev.wanolog.android.presentation.anime_all

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.randev.core.SortType
import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeListModel
import com.randev.domain.usecase.anime.GetAnimeSearchFilterUseCase
import com.randev.domain.usecase.anime.SearchRequest
import kotlinx.coroutines.flow.last

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
class AnimeSearchPagingSource(
    private val useCase: GetAnimeSearchFilterUseCase,
    private val query: String,
    private val sortType: SortType
): PagingSource<Int, AnimeListModel.AnimeModel>() {
    override fun getRefreshKey(state: PagingState<Int, AnimeListModel.AnimeModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AnimeListModel.AnimeModel> {
        val currentPage = params.key ?: 0
        return when(val response = useCase.invoke(SearchRequest(query, currentPage, sortType)).last()) {
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