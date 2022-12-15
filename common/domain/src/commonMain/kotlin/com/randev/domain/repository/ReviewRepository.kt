package com.randev.domain.repository

import com.randev.core.wrapper.Resource
import com.randev.domain.model.ReviewListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
interface ReviewRepository {
    suspend fun getReviewByAnime(animeId: String, page: Int): Flow<Resource<ReviewListModel>>
    suspend fun getReviewByManga(mangaId: String, page: Int): Flow<Resource<ReviewListModel>>
}