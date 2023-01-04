package com.ewalabs.domain.repository

import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.CommentListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 09/12/22
 */
interface CommentRepository {
    suspend fun getCommentsByPost(page: Int, postId: String): Flow<Resource<CommentListModel>>
}