package com.randev.domain.repository

import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeFavoriteModel
import com.randev.domain.model.MangaFavoriteModel
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