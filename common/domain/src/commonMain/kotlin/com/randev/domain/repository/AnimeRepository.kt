package com.randev.domain.repository

import com.randev.core.SortType
import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeDetailModel
import com.randev.domain.model.AnimeListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
interface AnimeRepository {
    suspend fun getAnimeAll(page: Int): Flow<Resource<AnimeListModel>>
    suspend fun getAnimeTrending(): Flow<Resource<AnimeListModel>>
    suspend fun getAnimeTopUpcoming(): Flow<Resource<AnimeListModel>>
    suspend fun getAnimeTopRating(): Flow<Resource<AnimeListModel>>
    suspend fun getAnimePopular(): Flow<Resource<AnimeListModel>>
    suspend fun getAnimeSearchFilter(query: String, page: Int, sortType: SortType): Flow<Resource<AnimeListModel>>
    suspend fun getAnimeDetail(id: String): Flow<Resource<AnimeDetailModel>>
    suspend fun getAnimeByCategory(categoryId: String, page: Int): Flow<Resource<AnimeListModel>>
}