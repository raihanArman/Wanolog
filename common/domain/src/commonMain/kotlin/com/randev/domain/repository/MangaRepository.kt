package com.randev.domain.repository

import com.randev.core.SortType
import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CategoryListModel
import com.randev.domain.model.MangaDetailModel
import com.randev.domain.model.MangaListModel
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