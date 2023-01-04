package com.ewalabs.data.datasource.remote

import com.ewalabs.core.SortType
import com.ewalabs.data.response.MangaDetailResponse
import com.ewalabs.data.response.MangaListResponse

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
    suspend fun fetchMangaDetail(id: String): MangaDetailResponse
    suspend fun fetchMangaByCategory(categoryId: String, page: Int): MangaListResponse
}