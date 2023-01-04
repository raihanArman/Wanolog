package com.ewalabs.domain.repository

import com.ewalabs.core.SortType
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.MangaDetailModel
import com.ewalabs.domain.model.MangaListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
interface MangaRepository {
    suspend fun getMangaAll(page: Int): Flow<Resource<MangaListModel>>
    suspend fun getMangaTrending(): Flow<Resource<MangaListModel>>
    suspend fun getMangaTopUpcoming(): Flow<Resource<MangaListModel>>
    suspend fun getMangaTopRating(): Flow<Resource<MangaListModel>>
    suspend fun getMangaPopular(): Flow<Resource<MangaListModel>>
    suspend fun getMangaSearchFilter(query: String, page: Int, sortType: SortType): Flow<Resource<MangaListModel>>
    suspend fun getMangaDetail(id: String): Flow<Resource<MangaDetailModel>>
    suspend fun getMangaByCategory(categoryId: String, page: Int): Flow<Resource<MangaListModel>>
}