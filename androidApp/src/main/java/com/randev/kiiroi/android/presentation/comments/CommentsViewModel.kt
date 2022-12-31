package com.randev.kiiroi.android.presentation.comments

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.randev.domain.model.CommentListModel
import com.randev.domain.usecase.comment.GetCommentsByPostUseCase
import com.randev.kiiroi.android.utils.SharingCommentAttr
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest

/**
 * @author Raihan Arman
 * @date 09/12/22
 */
class CommentsViewModel(
    private val useCase: GetCommentsByPostUseCase,
    private val commentAttr: SharingCommentAttr
): ViewModel() {

    val postId = commentAttr.postId

    @OptIn(ExperimentalCoroutinesApi::class)
    val commentsData = postId.filter {
        it.isNotEmpty()
    }.flatMapLatest {
        getDataAll(it)
    }

    private fun getDataAll(postId: String): Flow<PagingData<CommentListModel.CommentModel>> {
        return Pager(PagingConfig(pageSize = 20)) {
            CommentsPagingSource(useCase, postId)
        }.flow
    }
}