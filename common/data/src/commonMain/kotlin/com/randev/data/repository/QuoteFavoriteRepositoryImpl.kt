package com.randev.data.repository

import com.randev.core.wrapper.Resource
import com.randev.data.datasource.local.QuoteFavoriteDataSource
import com.randev.data.mapper.QuoteFavoriteMapper
import com.randev.domain.model.QuoteFavoriteModel
import com.randev.domain.repository.QuoteFavoriteRepository
import com.randev.wanolog.db.QuoteFavoriteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author Raihan Arman
 * @date 25/12/22
 */
class QuoteFavoriteRepositoryImpl(
    private val dataSource: QuoteFavoriteDataSource,
    private val mapper: QuoteFavoriteMapper
): QuoteFavoriteRepository {
    override suspend fun getFavorite(): Flow<Resource<List<QuoteFavoriteModel>>> {
        return flow {
            emit(
                Resource.Success(dataSource.getFavoriteAll().map { mapper.map(it) })
            )
        }
    }

    override suspend fun isFavoriteQuote(quote: String): Flow<Resource<Boolean>> {
        val data = dataSource.getFavoriteByQuote(quote)
        return flow {
            emit(
                Resource.Success(data != null)
            )
        }
    }

    override suspend fun insertFavorite(
        quote: String,
        anime: String,
        character: String,
        backgroundColor: String
    ): Flow<Resource<Long>> {
        return flow {
            val result = dataSource.insertFavorite(
                entity = QuoteFavoriteEntity(
                    anime = anime,
                    quote = quote,
                    character = character,
                    backgroundColor = backgroundColor
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

    override suspend fun deleteFavorite(quote: String): Flow<Resource<Long>> {
        return flow {
            emit(
                Resource.Success(dataSource.deleteFavoriteByQuote(quote))
            )
        }
    }
}