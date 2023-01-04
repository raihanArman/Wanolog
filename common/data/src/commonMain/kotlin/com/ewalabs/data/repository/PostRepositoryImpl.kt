package com.ewalabs.data.repository

import com.ewalabs.core.wrapper.NetworkResource
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.data.datasource.remote.PostApiClient
import com.ewalabs.data.mapper.PostListMapper
import com.ewalabs.domain.model.PostListModel
import com.ewalabs.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 07/12/22
 */
class PostRepositoryImpl(
    private val mapper: PostListMapper,
    private val api: PostApiClient
): PostRepository {
    override suspend fun getPosts(page: Int): Flow<Resource<PostListModel>> {
        return object : NetworkResource<PostListModel>() {
            override suspend fun remoteFetch(): PostListModel {
                val request = api.fetchPosts(page*20)
                return mapper.map(request)
            }
        }.asFlow()
    }

}