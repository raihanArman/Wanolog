package com.randev.data.datasource.remote

import com.randev.data.response.AnimeListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * @author Raihan Arman
 * @date 16/11/22
 */

class AnimeApi(
    private val ktor: HttpClient
): AnimeApiClient {
    override suspend fun fetchAnimeAll(): AnimeListResponse {
        return ktor.get("api/edge/anime") {
            parameter("page[limit]", 20)
        }.body()

    }

    override suspend fun fetchAnimeTrending(): AnimeListResponse {
        return ktor.get("api/edge/trending/anime") {
            parameter("page[limit]", 20)
        }.body()
    }
}