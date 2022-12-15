package com.randev.data.datasource.remote

import com.randev.core.SortType
import com.randev.data.response.AnimeDetailResponse
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
    override suspend fun fetchAnimeAll(page: Int): AnimeListResponse {
        return ktor.get("api/edge/anime") {
            parameter("page[limit]", 20)
            parameter("sort", "-updatedAt")
            parameter("page[offset]", page)
        }.body()
    }

    override suspend fun fetchAnimeTrending(): AnimeListResponse {
        return ktor.get("api/edge/trending/anime") {
            parameter("page[limit]", 20)
        }.body()
    }

    override suspend fun fetchAnimeTopUpcoming(): AnimeListResponse {
        return ktor.get("api/edge/anime") {
            parameter("page[limit]", 20)
            parameter("filter[status]", "upcoming")
        }.body()
    }

    override suspend fun fetchAnimeTopRating(): AnimeListResponse {
        return ktor.get("api/edge/anime") {
            parameter("page[limit]", 20)
            parameter("sort", "-averageRating")
        }.body()
    }

    override suspend fun fetchAnimePopular(): AnimeListResponse {
        return ktor.get("api/edge/anime") {
            parameter("page[limit]", 20)
            parameter("sort", "popularityRank")
        }.body()
    }

    override suspend fun fetchAnimeSearchFilter(
        query: String,
        page: Int,
        sortType: SortType
    ): AnimeListResponse {
        return ktor.get("api/edge/anime") {
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

    override suspend fun fetchAnimeDetail(id: String): AnimeDetailResponse {
        return ktor.get("api/edge/anime/$id") {
            parameter("include", "categories,streamingLinks.streamer,reviews.user,animeProductions.producer,animeCharacters.character,mediaRelationships.destination")
            parameter("fields[categories]", "nsfw,slug,title")
            parameter("fields[reviews]", "rating,content,user")
            parameter("fields[users]", "name,avatar")
            parameter("fields[producers]", "name")
            parameter("fields[characters]", "image,name")
        }.body()
    }

    override suspend fun fetchAnimeByCategory(categoryId: String, page: Int): AnimeListResponse {
        return ktor.get("api/edge/categories/$categoryId/anime") {
            parameter("page[limit]", 20)
            parameter("page[offset]", page)
        }.body()
    }
}