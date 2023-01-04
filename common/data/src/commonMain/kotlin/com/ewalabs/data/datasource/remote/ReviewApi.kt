package com.ewalabs.data.datasource.remote

import com.ewalabs.data.response.ReviewListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class ReviewApi(
    private val ktor: HttpClient
): ReviewApiClient {
    override suspend fun fetchReviewAnime(animeId: String, page: Int): ReviewListResponse {
        return ktor.get("api/edge/anime/$animeId/reviews") {
            parameter("include", "user")
            parameter("page[limit]", 20)
            parameter("page[offset]", page)
        }.body()
    }

    override suspend fun fetchReviewManga(mangaId: String, page: Int): ReviewListResponse {
        return ktor.get("api/edge/manga/$mangaId/reviews") {
            parameter("include", "user")
            parameter("page[limit]", 20)
            parameter("page[offset]", page)
        }.body()
    }
}