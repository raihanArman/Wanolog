package com.randev.data.repository

import com.randev.core.wrapper.NetworkResource
import com.randev.core.wrapper.Resource
import com.randev.data.datasource.remote.MangaApiClient
import com.randev.data.mapper.MangaListMapper
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.MangaListModel
import com.randev.domain.repository.MangaRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
class MangaRepositoryImpl(
    private val api: MangaApiClient,
    private val mapper: MangaListMapper,
): MangaRepository {
    override suspend fun getMangaAll(): Flow<Resource<MangaListModel>> {
        return object : NetworkResource<MangaListModel>() {
            override suspend fun remoteFetch(): MangaListModel {
                val request = api.fetchMangaAll()
                return mapper.map(request)
            }
        }.asFlow()
    }

    override suspend fun getMangaTrending(): Flow<Resource<MangaListModel>> {
        return object : NetworkResource<MangaListModel>() {
            override suspend fun remoteFetch(): MangaListModel {
                val request = api.fetchMangaTrending()
                return mapper.map(request)
            }
        }.asFlow()
    }

    override suspend fun getMangaTopUpcoming(): Flow<Resource<MangaListModel>> {
        return object : NetworkResource<MangaListModel>() {
            override suspend fun remoteFetch(): MangaListModel {
                val request = api.fetchMangaTopUpcoming()
                return mapper.map(request)
            }
        }.asFlow()
    }

    override suspend fun getMangaTopRating(): Flow<Resource<MangaListModel>> {
        return object : NetworkResource<MangaListModel>() {
            override suspend fun remoteFetch(): MangaListModel {
                val request = api.fetchMangaTopRating()
                return mapper.map(request)
            }
        }.asFlow()
    }

    override suspend fun getMangaPopular(): Flow<Resource<MangaListModel>> {
        return object : NetworkResource<MangaListModel>() {
            override suspend fun remoteFetch(): MangaListModel {
                val request = api.fetchMangaPopular()
                return mapper.map(request)
            }
        }.asFlow()
    }
}