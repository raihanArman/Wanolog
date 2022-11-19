package com.randev.domain.repository

import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CategoryListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

interface CategoryRepository {
    suspend fun getCategoryAll(): Flow<Resource<CategoryListModel>>
}