package com.randev.domain.repository

import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeFavoriteModel
import com.randev.domain.model.QuoteFavoriteModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 25/12/22
 */
interface QuoteFavoriteRepository {
    suspend fun getFavorite(): Flow<Resource<List<QuoteFavoriteModel>>>
    suspend fun isFavoriteQuote(quote: String): Flow<Resource<Boolean>>
    suspend fun insertFavorite(
        quote: String,
        anime: String,
        character: String,
    ): Flow<Resource<Long>>
    suspend fun deleteFavorite(quote: String): Flow<Resource<Long>>
}