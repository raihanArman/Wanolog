package com.randev.data.datasource.remote

import com.randev.core.SortType
import com.randev.data.response.AnimeListResponse
import com.randev.data.response.MangaDetailResponse
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

    override suspend fun fetchMangaAll(page: Int): MangaListResponse {
        return ktor.get("api/edge/manga") {
            parameter("page[limit]", 20)
            parameter("sort", "-updatedAt")
            parameter("page[offset]", page)
        }.body()
    }

    override suspend fun fetchMangaTopUpcoming(): MangaListResponse {
        return ktor.get("api/edge/manga") {
            parameter("page[limit]", 20)
            parameter("filter[status]", "upcoming")
        }.body()
    }

    override suspend fun fetchMangaTopRating(): MangaListResponse {
        return ktor.get("api/edge/manga") {
            parameter("page[limit]", 20)
            parameter("sort", "-averageRating")
        }.body()
    }

    override suspend fun fetchMangaPopular(): MangaListResponse {
        return ktor.get("api/edge/manga") {
            parameter("page[limit]", 20)
            parameter("sort", "popularityRank")
        }.body()
    }

    override suspend fun fetchMangaSearchFilter(
        query: String,
        page: Int,
        sortType: SortType
    ): MangaListResponse {
        return ktor.get("api/edge/manga") {
            parameter("page[limit]", 20)
            if (query.isNotBlank()) {
                parameter("filter[text]", query)
            }
            parameter("page[offset]", page)
            if (sortType.path.isNotEmpty()) {
                parameter("sort", sortType.path)
            }
        }.body()
    }

    override suspend fun fetchMangaDetail(id: String): MangaDetailResponse {
        return ktor.get("api/edge/manga/$id") {
            parameter("include", "categories,reviews.user,mediaRelationships.destination,characters.character,mediaRelationships.destination")
            parameter("fields[categories]", "nsfw,slug,title")
            parameter("fields[reviews]", "rating,content,user")
            parameter("fields[users]", "name,avatar")
            parameter("fields[producers]", "name")
            parameter("fields[characters]", "image,name")
        }.body()
    }

    override suspend fun fetchMangaByCategory(categoryId: String, page: Int): MangaListResponse {
        return ktor.get("api/edge/categories/$categoryId/manga") {
            parameter("page[limit]", 20)
            parameter("page[offset]", page)
        }.body()
    }

}