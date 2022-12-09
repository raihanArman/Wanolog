package com.randev.domain.usecase.comment

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.CommentListModel
import com.randev.domain.repository.CommentRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 09/12/22
 */
class GetCommentsByPostUseCase(
    private val repository: CommentRepository
): FlowUseCase<CommentsRequest?, CommentListModel>() {
    override suspend fun execute(parameters: CommentsRequest?): Flow<Resource<CommentListModel>> {
        return repository.getCommentsByPost(parameters!!.page, parameters.id)
    }
}

data class CommentsRequest(
    val page: Int,
    val id: String
)