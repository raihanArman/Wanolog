package com.randev.domain.repository

import com.randev.core.wrapper.Resource
import com.randev.domain.model.CategoryListModel
import com.randev.domain.model.MangaListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
interface MangaRepository {
    suspend fun getMangaAll(): Flow<Resource<MangaListModel>>
    suspend fun getMangaTrending(): Flow<Resource<MangaListModel>>
    suspend fun getMangaTopUpcoming(): Flow<Resource<MangaListModel>>
    suspend fun getMangaTopRating(): Flow<Resource<MangaListModel>>
    suspend fun getMangaPopular(): Flow<Resource<MangaListModel>>
}