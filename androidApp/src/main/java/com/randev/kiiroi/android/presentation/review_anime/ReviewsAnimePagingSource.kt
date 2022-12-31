package com.randev.kiiroi.android.presentation.review_anime

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.randev.core.wrapper.Resource
import com.randev.domain.model.ReviewModel
import com.randev.domain.usecase.review.GetAnimeReviewUseCase
import com.randev.domain.usecase.review.ReviewAnimeRequest
import kotlinx.coroutines.flow.last

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class ReviewsAnimePagingSource(
    private val useCase: GetAnimeReviewUseCase,
    private val animeId: String
): PagingSource<Int, ReviewModel>()  {
    override fun getRefreshKey(state: PagingState<Int, ReviewModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ReviewModel> {
        val currentPage = params.key ?: 1
        return when(val response = useCase.invoke(ReviewAnimeRequest(currentPage, animeId)).last()) {
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