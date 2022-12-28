package com.randev.data.repository

import com.randev.core.wrapper.Resource
import com.randev.data.datasource.local.AnimeFavoriteDataSource
import com.randev.data.mapper.AnimeFavoriteMapper
import com.randev.domain.model.AnimeFavoriteModel
import com.randev.domain.repository.AnimeFavoriteRepository
import com.randev.wanolog.db.AnimeFavoriteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author Raihan Arman
 * @date 25/12/22
 */
class AnimeFavoriteRepositoryImpl(
    private val dataSource: AnimeFavoriteDataSource,
    private val mapper: AnimeFavoriteMapper
): AnimeFavoriteRepository {
    override suspend fun getFavorite(): Flow<Resource<List<AnimeFavoriteModel>>> {
        return flow {
            val data = dataSource.getFavoriteAll().map { mapper.map(it) }
            println("Anime Favorite Repo -> $data")
            emit(
                Resource.Success(data)
            )
        }
    }

    override suspend fun insertFavorite(
        id: Long,
        title: String,
        poster: String,
        rate: String
    ): Flow<Resource<Long>> {
        return flow {
            val result = dataSource.insertFavorite(
                entity = AnimeFavoriteEntity(
                    id = id,
                    title = title,
                    poster = poster,
                    rate = rate
                )
            )
            println("Result -> $result")
            emit(
                Resource.Success(
                    result
                )
            )
        }
    }

    override suspend fun deleteFavorite(id: Long): Flow<Resource<Long>> {
        return flow {
            emit(
                Resource.Success(dataSource.deleteFavoriteById(id))
            )
        }
    }
}