package com.ewalabs.domain.repository

import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.MangaFavoriteModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 25/12/22
 */
interface MangaFavoriteRepository {
    suspend fun getFavorite(): Flow<Resource<List<MangaFavoriteModel>>>
    suspend fun insertFavorite(
        id: Long,
        title: String,
        poster: String,
        rate: String,
    ): Flow<Resource<Long>>
    suspend fun deleteFavorite(id: Long): Flow<Resource<Long>>
}