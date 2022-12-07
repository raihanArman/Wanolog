package com.randev.data.repository

import com.randev.core.wrapper.NetworkResource
import com.randev.core.wrapper.Resource
import com.randev.data.datasource.remote.AnimeApiClient
import com.randev.data.datasource.remote.PostApiClient
import com.randev.data.mapper.AnimeDetailMapper
import com.randev.data.mapper.AnimeListMapper
import com.randev.data.mapper.PostListMapper
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.PostListModel
import com.randev.domain.repository.PostRepository
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