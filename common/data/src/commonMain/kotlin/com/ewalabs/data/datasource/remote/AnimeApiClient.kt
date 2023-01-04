package com.ewalabs.data.datasource.remote

import com.ewalabs.core.SortType
import com.ewalabs.data.response.AnimeDetailResponse
import com.ewalabs.data.response.AnimeListResponse

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
interface AnimeApiClient {
    suspend fun fetchAnimeAll(page: Int): AnimeListResponse
    suspend fun fetchAnimeTrending(): AnimeListResponse
    suspend fun fetchAnimeTopUpcoming(): AnimeListResponse
    suspend fun fetchAnimeTopRating(): AnimeListResponse
    suspend fun fetchAnimePopular(): AnimeListResponse
    suspend fun fetchAnimeSearchFilter(
        query: String,
        page: Int,
        sortType: SortType
    ): AnimeListResponse
    suspend fun fetchAnimeDetail(id: String): AnimeDetailResponse
    suspend fun fetchAnimeByCategory(categoryId: String, page: Int): AnimeListResponse
}