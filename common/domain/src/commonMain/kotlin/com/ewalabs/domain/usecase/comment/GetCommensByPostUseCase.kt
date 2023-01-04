package com.ewalabs.domain.usecase.comment

import com.ewalabs.core.wrapper.FlowUseCase
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.CommentListModel
import com.ewalabs.domain.repository.CommentRepository
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