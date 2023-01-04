package com.ewalabs.data.datasource.remote

import com.ewalabs.data.response.CommentListResponse

/**
 * @author Raihan Arman
 * @date 08/12/22
 */
interface CommentApiClient {
    suspend fun fetchComments(page: Int, postId: String): CommentListResponse
}