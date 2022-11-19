package com.randev.data.datasource.remote

import com.randev.data.response.MangaListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * @author Raihan Arman
 * @date 19/11/22
 */

class MangaApi(
    private val ktor: HttpClient
): MangaApiClient {
    override suspend fun fetchMangaTrending(): MangaListResponse {
        return ktor.get("api/edge/trending/manga") {
            parameter("page[limit]", 20)
        }.body()
    }

    override suspend fun fetchMangaAll(): MangaListResponse {
        return ktor.get("api/edge/manga") {
            parameter("page[limit]", 20)
            parameter("sort", "-updatedAt")
        }.body()
    }

}