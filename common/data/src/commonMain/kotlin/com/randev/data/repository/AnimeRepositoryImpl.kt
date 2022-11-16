package com.randev.data.repository

import com.randev.core.wrapper.NetworkResource
import com.randev.core.wrapper.Resource
import com.randev.data.datasource.remote.AnimeApi
import com.randev.data.mapper.AnimeListMapper
import com.randev.domain.model.AnimeListModel
import com.randev.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
class AnimeRepositoryImpl(
    private val mapper: AnimeListMapper,
    private val api: AnimeApi
): AnimeRepository {
    override suspend fun getAnimeAll(): Flow<Resource<AnimeListModel>> {
        return object : NetworkResource<AnimeListModel>() {
            override suspend fun remoteFetch(): AnimeListModel {
                val request = api.fetchAnimeAll()
                return mapper.map(request)
            }
        }.asFlow()
    }
}