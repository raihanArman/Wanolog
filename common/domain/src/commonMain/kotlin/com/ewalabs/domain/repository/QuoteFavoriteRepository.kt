package com.ewalabs.domain.repository

import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.QuoteFavoriteModel
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
        backgroundColor: String
    ): Flow<Resource<Long>>
    suspend fun deleteFavorite(quote: String): Flow<Resource<Long>>
}