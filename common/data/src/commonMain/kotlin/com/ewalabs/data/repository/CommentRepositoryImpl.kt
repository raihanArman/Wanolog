package com.ewalabs.data.repository

import com.ewalabs.core.wrapper.NetworkResource
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.data.datasource.remote.CommentApiClient
import com.ewalabs.data.mapper.CommentListMapper
import com.ewalabs.domain.model.CommentListModel
import com.ewalabs.domain.repository.CommentRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 09/12/22
 */
class CommentRepositoryImpl(
    private val mapper: CommentListMapper,
    private val api: CommentApiClient
): CommentRepository {
    override suspend fun getCommentsByPost(
        page: Int,
        postId: String
    ): Flow<Resource<CommentListModel>> {
        return object : NetworkResource<CommentListModel>() {
            override suspend fun remoteFetch(): CommentListModel {
                val request = api.fetchComments(page*20, postId)
                return mapper.map(request)
            }
        }.asFlow()
    }
}