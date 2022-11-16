package com.randev.domain.repository

import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
interface AnimeRepository {
    suspend fun getAnimeAll(): Flow<Resource<AnimeListModel>>
}