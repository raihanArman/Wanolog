package com.randev.data.datasource.remote

import com.randev.data.response.CommentListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * @author Raihan Arman
 * @date 08/12/22
 */
class CommentApi(
    private val ktor: HttpClient
): CommentApiClient {
    override suspend fun fetchComments(page: Int, postId: String): CommentListResponse {
        return ktor.get("api/edge/comments") {
            parameter("page[limit]", 20)
            parameter("sort", "-createdAt")
            parameter("include", "post,user,replies")
            parameter("filter[post.id]", postId)
            parameter("page[offset]", page)
        }.body()
    }
}