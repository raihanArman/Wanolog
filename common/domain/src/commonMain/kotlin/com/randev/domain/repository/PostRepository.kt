package com.randev.domain.repository

import com.randev.core.wrapper.Resource
import com.randev.domain.model.PostListModel
import com.randev.domain.model.UserListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 07/12/22
 */
interface PostRepository {
    suspend fun getPosts(page: Int): Flow<Resource<PostListModel>>
}