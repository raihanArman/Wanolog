package com.ewalabs.data.datasource.remote

import com.ewalabs.data.response.PostListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * @author Raihan Arman
 * @date 07/12/22
 */
class PostApi(
    private val ktor: HttpClient
): PostApiClient {
    override suspend fun fetchPosts(page: Int): PostListResponse {
        return ktor.get("api/edge/posts") {
            parameter("include", "user,media,postLikes.user,uploads")
            parameter("sort", "-createdAt")
            parameter("page[limit]", "20")
            parameter("page[offset]", page)
        }.body()
    }
}