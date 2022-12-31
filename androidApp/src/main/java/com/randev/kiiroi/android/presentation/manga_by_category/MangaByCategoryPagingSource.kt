package com.randev.kiiroi.android.presentation.manga_by_category

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.randev.core.wrapper.Resource
import com.randev.domain.model.MangaListModel
import com.randev.domain.usecase.manga.GetMangaByCategoryUseCase
import com.randev.domain.usecase.manga.MangaByCategoryRequest
import kotlinx.coroutines.flow.last

/**
 * @author Raihan Arman
 * @date 13/12/22
 */
class MangaByCategoryPagingSource(
    private val useCase: GetMangaByCategoryUseCase,
    private val categoryId: String,
): PagingSource<Int, MangaListModel.MangaModel>() {
    override fun getRefreshKey(state: PagingState<Int, MangaListModel.MangaModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MangaListModel.MangaModel> {
        val currentPage = params.key ?: 0
        return when(val response = useCase.invoke(MangaByCategoryRequest(categoryId = categoryId, page = currentPage)).last()) {
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