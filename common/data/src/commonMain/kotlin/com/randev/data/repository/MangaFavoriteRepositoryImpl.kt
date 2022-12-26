package com.randev.data.repository

import com.randev.core.wrapper.Resource
import com.randev.data.datasource.local.AnimeFavoriteDataSource
import com.randev.data.datasource.local.MangaFavoriteDataSource
import com.randev.data.mapper.AnimeFavoriteMapper
import com.randev.data.mapper.MangaFavoriteMapper
import com.randev.domain.model.AnimeFavoriteModel
import com.randev.domain.model.MangaFavoriteModel
import com.randev.domain.repository.AnimeFavoriteRepository
import com.randev.domain.repository.MangaFavoriteRepository
import com.randev.wanolog.db.AnimeFavoriteEntity
import com.randev.wanolog.db.MangaFavoriteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author Raihan Arman
 * @date 25/12/22
 */
class MangaFavoriteRepositoryImpl(
    private val dataSource: MangaFavoriteDataSource,
    private val mapper: MangaFavoriteMapper
): MangaFavoriteRepository {
    override suspend fun getFavorite(): Flow<Resource<List<MangaFavoriteModel>>> {
        return flow {
            emit(
                Resource.Success(dataSource.getFavoriteAll().map { mapper.map(it) })
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
                entity = MangaFavoriteEntity(
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