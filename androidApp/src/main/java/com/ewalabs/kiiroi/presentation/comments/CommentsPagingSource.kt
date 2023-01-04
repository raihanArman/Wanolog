package com.ewalabs.kiiroi.presentation.comments

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.CommentListModel
import com.ewalabs.domain.usecase.comment.CommentsRequest
import com.ewalabs.domain.usecase.comment.GetCommentsByPostUseCase
import kotlinx.coroutines.flow.last

/**
 * @author Raihan Arman
 * @date 09/12/22
 */
class CommentsPagingSource(
    private val useCase: GetCommentsByPostUseCase,
    private val postId: String
): PagingSource<Int, CommentListModel.CommentModel>() {
    override fun getRefreshKey(state: PagingState<Int, CommentListModel.CommentModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CommentListModel.CommentModel> {
        val currentPage = params.key ?: 1
        return when(val response = useCase.invoke(CommentsRequest(currentPage, postId)).last()) {
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