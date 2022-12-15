package com.randev.data.repository

import com.randev.core.wrapper.NetworkResource
import com.randev.core.wrapper.Resource
import com.randev.data.datasource.remote.ReviewApiClient
import com.randev.data.mapper.ReviewListMapper
import com.randev.domain.model.ReviewListModel
import com.randev.domain.repository.ReviewRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class ReviewRepositoryImpl(
    private val api: ReviewApiClient,
    private val mapper: ReviewListMapper
): ReviewRepository {
    override suspend fun getReviewByAnime(
        animeId: String,
        page: Int
    ): Flow<Resource<ReviewListModel>> {
        return object : NetworkResource<ReviewListModel>() {
            override suspend fun remoteFetch(): ReviewListModel {
                val request = api.fetchReviewAnime(animeId,page*20)
                return mapper.map(request)
            }
        }.asFlow()
    }

    override suspend fun getReviewByManga(
        mangaId: String,
        page: Int
    ): Flow<Resource<ReviewListModel>> {
        return object : NetworkResource<ReviewListModel>() {
            override suspend fun remoteFetch(): ReviewListModel {
                val request = api.fetchReviewManga(mangaId,page*20)
                return mapper.map(request)
            }
        }.asFlow()
    }
}