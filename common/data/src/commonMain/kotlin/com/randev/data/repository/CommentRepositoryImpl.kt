package com.randev.data.repository

import com.randev.core.wrapper.NetworkResource
import com.randev.core.wrapper.Resource
import com.randev.data.datasource.remote.AnimeApiClient
import com.randev.data.datasource.remote.CommentApiClient
import com.randev.data.mapper.AnimeDetailMapper
import com.randev.data.mapper.AnimeListMapper
import com.randev.data.mapper.CommentListMapper
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CommentListModel
import com.randev.domain.repository.CommentRepository
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