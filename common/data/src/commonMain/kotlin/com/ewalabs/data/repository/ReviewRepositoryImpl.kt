package com.ewalabs.data.repository

import com.ewalabs.core.wrapper.NetworkResource
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.data.datasource.remote.ReviewApiClient
import com.ewalabs.data.mapper.ReviewListMapper
import com.ewalabs.domain.model.ReviewListModel
import com.ewalabs.domain.repository.ReviewRepository
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