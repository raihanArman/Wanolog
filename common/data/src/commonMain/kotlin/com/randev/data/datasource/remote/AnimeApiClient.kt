package com.randev.data.datasource.remote

import com.randev.data.response.AnimeListResponse

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
interface AnimeApiClient {
    suspend fun fetchAnimeAll(): AnimeListResponse
    suspend fun fetchAnimeTrending(): AnimeListResponse
    suspend fun fetchAnimeTopUpcoming(): AnimeListResponse
    suspend fun fetchAnimeTopRating(): AnimeListResponse
    suspend fun fetchAnimePopular(): AnimeListResponse
}