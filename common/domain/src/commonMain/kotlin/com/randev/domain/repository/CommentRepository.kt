package com.randev.domain.repository

import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CommentListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 09/12/22
 */
interface CommentRepository {
    suspend fun getCommentsByPost(page: Int, postId: String): Flow<Resource<CommentListModel>>
}