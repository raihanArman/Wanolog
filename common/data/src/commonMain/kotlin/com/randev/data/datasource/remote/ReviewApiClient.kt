package com.randev.data.datasource.remote

import com.randev.data.response.ReviewListResponse

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
interface ReviewApiClient {
    suspend fun fetchReviewAnime(animeId: String, page: Int): ReviewListResponse
    suspend fun fetchReviewManga(mangaId: String, page: Int): ReviewListResponse
}