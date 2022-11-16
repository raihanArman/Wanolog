package com.randev.data.datasource.remote

import com.randev.data.response.AnimeListResponse

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
interface AnimeApiClient {
    suspend fun fetchAnimeAll(): AnimeListResponse
}