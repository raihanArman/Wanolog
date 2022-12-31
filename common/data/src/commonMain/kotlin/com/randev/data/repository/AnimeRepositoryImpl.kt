package com.randev.data.repository

import com.randev.core.SortType
import com.randev.core.wrapper.NetworkResource
import com.randev.core.wrapper.Resource
import com.randev.data.datasource.local.AnimeFavoriteDataSource
import com.randev.data.datasource.remote.AnimeApi
import com.randev.data.datasource.remote.AnimeApiClient
import com.randev.data.mapper.AnimeDetailMapper
import com.randev.data.mapper.AnimeListMapper
import com.randev.domain.model.AnimeDetailModel
import com.randev.domain.model.AnimeListModel
import com.randev.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
class AnimeRepositoryImpl(
    private val mapper: AnimeListMapper,
    private val mapperDetail: AnimeDetailMapper,
    private val api: AnimeApiClient,
    private val favoriteDataSource: AnimeFavoriteDataSource
): AnimeRepository {
    override suspend fun getAnimeAll(page: Int): Flow<Resource<AnimeListModel>> {
        return object : NetworkResource<AnimeListModel>() {
            override suspend fun remoteFetch(): AnimeListModel {
                val request = api.fetchAnimeAll(page)
                return mapper.map(request)
            }
        }.asFlow()
    }

    override suspend fun getAnimeTrending(): Flow<Resource<AnimeListModel>> {
        return object : NetworkResource<AnimeListModel>() {
            override suspend fun remoteFetch(): AnimeListModel {
                val request = api.fetchAnimeTrending()
                return mapper.map(request)
            }
        }.asFlow()
    }

    override suspend fun getAnimeTopUpcoming(): Flow<Resource<AnimeListModel>> {
        return object : NetworkResource<AnimeListModel>() {
            override suspend fun remoteFetch(): AnimeListModel {
                val request = api.fetchAnimeTopUpcoming()
                return mapper.map(request)
            }
        }.asFlow()
    }

    override suspend fun getAnimeTopRating(): Flow<Resource<AnimeListModel>> {
        return object : NetworkResource<AnimeListModel>() {
            override suspend fun remoteFetch(): AnimeListModel {
                val request = api.fetchAnimeTopRating()
                return mapper.map(request)
            }
        }.asFlow()
    }

    override suspend fun getAnimePopular(): Flow<Resource<AnimeListModel>> {
        return object : NetworkResource<AnimeListModel>() {
            override suspend fun remoteFetch(): AnimeListModel {
                val request = api.fetchAnimePopular()
                return mapper.map(request)
            }
        }.asFlow()
    }

    override suspend fun getAnimeSearchFilter(
        query: String,
        page: Int,
        sortType: SortType
    ): Flow<Resource<AnimeListModel>> {
        return object : NetworkResource<AnimeListModel>() {
            override suspend fun remoteFetch(): AnimeListModel {
                val request = api.fetchAnimeSearchFilter(query, page*20, sortType)
                return mapper.map(request)
            }
        }.asFlow()
    }

    override suspend fun getAnimeDetail(id: String): Flow<Resource<AnimeDetailModel>> {
        return object : NetworkResource<AnimeDetailModel>() {
            override suspend fun remoteFetch(): AnimeDetailModel {
                val request = api.fetchAnimeDetail(id)
                return mapperDetail.map(request).apply {
                    val favorite = favoriteDataSource.getFavoriteById(id.toLong())
                    isFavorite = favorite != null
                }
            }
        }.asFlow()
    }

    override suspend fun getAnimeByCategory(categoryId: String, page: Int): Flow<Resource<AnimeListModel>> {
        return object : NetworkResource<AnimeListModel>() {
            override suspend fun remoteFetch(): AnimeListModel {
                val request = api.fetchAnimeByCategory(categoryId, page*20)
                return mapper.map(request)
            }
        }.asFlow()
    }
}