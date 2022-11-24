package com.randev.data.datasource.remote

import com.randev.core.SortType
import com.randev.data.response.AnimeListResponse
import com.randev.data.response.MangaListResponse

/**
 * @author Raihan Arman
 * @date 19/11/22
 */

interface MangaApiClient {
    suspend fun fetchMangaTrending(): MangaListResponse
    suspend fun fetchMangaAll(page: Int): MangaListResponse
    suspend fun fetchMangaTopUpcoming(): MangaListResponse
    suspend fun fetchMangaTopRating(): MangaListResponse
    suspend fun fetchMangaPopular(): MangaListResponse
    suspend fun fetchMangaSearchFilter(
        query: String,
        page: Int,
        sortType: SortType
    ): MangaListResponse
}