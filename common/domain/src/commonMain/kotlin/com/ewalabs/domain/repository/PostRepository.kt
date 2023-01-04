package com.ewalabs.domain.repository

import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.PostListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 07/12/22
 */
interface PostRepository {
    suspend fun getPosts(page: Int): Flow<Resource<PostListModel>>
}