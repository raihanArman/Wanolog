package com.ewalabs.data.repository

import com.ewalabs.core.SortType
import com.ewalabs.core.wrapper.NetworkResource
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.data.datasource.local.MangaFavoriteDataSource
import com.ewalabs.data.datasource.remote.MangaApiClient
import com.ewalabs.data.mapper.MangaDetailMapper
import com.ewalabs.data.mapper.MangaListMapper
import com.ewalabs.domain.model.MangaDetailModel
import com.ewalabs.domain.model.MangaListModel
import com.ewalabs.domain.repository.MangaRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
class MangaRepositoryImpl(
    private val api: MangaApiClient,
    private val mapper: MangaListMapper,
    private val mapperDetail: MangaDetailMapper,
    private val favoriteDataSource: MangaFavoriteDataSource
): MangaRepository {
    override suspend fun getMangaAll(page: Int): Flow<Resource<MangaListModel>> {
        return object : NetworkResource<MangaListModel>() {
            override suspend fun remoteFetch(): MangaListModel {
                val request = api.fetchMangaAll(page*20)
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

    override suspend fun getMangaSearchFilter(
        query: String,
        page: Int,
        sortType: SortType
    ): Flow<Resource<MangaListModel>> {
        return object : NetworkResource<MangaListModel>() {
            override suspend fun remoteFetch(): MangaListModel {
                val request = api.fetchMangaSearchFilter(query, page*20, sortType)
                return mapper.map(request)
            }
        }.asFlow()
    }

    override suspend fun getMangaDetail(id: String): Flow<Resource<MangaDetailModel>> {
        return object : NetworkResource<MangaDetailModel>() {
            override suspend fun remoteFetch(): MangaDetailModel {
                val request = api.fetchMangaDetail(id)
                return mapperDetail.map(request).apply {
                    val favorite = favoriteDataSource.getFavoriteById(id.toLong())
                    isFavorite = favorite != null
                }
            }
        }.asFlow()
    }

    override suspend fun getMangaByCategory(
        categoryId: String,
        page: Int
    ): Flow<Resource<MangaListModel>> {
        return object : NetworkResource<MangaListModel>() {
            override suspend fun remoteFetch(): MangaListModel {
                val request = api.fetchMangaByCategory(categoryId, page*20)
                return mapper.map(request)
            }
        }.asFlow()
    }
}