package com.ewalabs.kiiroi.presentation.anime_by_category

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.AnimeListModel
import com.ewalabs.domain.usecase.anime.AnimeByCategoryRequest
import com.ewalabs.domain.usecase.anime.GetAnimeByCategoryUseCase
import kotlinx.coroutines.flow.last

/**
 * @author Raihan Arman
 * @date 13/12/22
 */
class AnimeByCategoryPagingSource(
    private val useCase: GetAnimeByCategoryUseCase,
    private val categoryId: String,
): PagingSource<Int, AnimeListModel.AnimeModel>() {
    override fun getRefreshKey(state: PagingState<Int, AnimeListModel.AnimeModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AnimeListModel.AnimeModel> {
        val currentPage = params.key ?: 0
        return when(val response = useCase.invoke(AnimeByCategoryRequest(categoryId = categoryId, page = currentPage)).last()) {
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