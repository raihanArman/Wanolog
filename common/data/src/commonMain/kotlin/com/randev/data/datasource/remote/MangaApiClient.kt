package com.randev.data.datasource.remote

import com.randev.data.response.MangaListResponse

/**
 * @author Raihan Arman
 * @date 19/11/22
 */

interface MangaApiClient {
    suspend fun fetchMangaTrending(): MangaListResponse
    suspend fun fetchMangaAll(): MangaListResponse
    suspend fun fetchMangaTopUpcoming(): MangaListResponse
    suspend fun fetchMangaTopRating(): MangaListResponse
    suspend fun fetchMangaPopular(): MangaListResponse
}