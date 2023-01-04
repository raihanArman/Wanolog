package com.ewalabs.data.datasource.remote

import com.ewalabs.data.response.PostListResponse

/**
 * @author Raihan Arman
 * @date 07/12/22
 */
interface PostApiClient {
    suspend fun fetchPosts(page: Int): PostListResponse
}