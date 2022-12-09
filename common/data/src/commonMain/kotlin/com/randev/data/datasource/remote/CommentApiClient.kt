package com.randev.data.datasource.remote

import com.randev.data.response.CommentListResponse
import com.randev.data.response.PostListResponse

/**
 * @author Raihan Arman
 * @date 08/12/22
 */
interface CommentApiClient {
    suspend fun fetchComments(page: Int, postId: String): CommentListResponse
}