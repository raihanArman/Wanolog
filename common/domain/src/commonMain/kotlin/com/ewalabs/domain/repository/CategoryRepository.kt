package com.ewalabs.domain.repository

import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.CategoryListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

interface CategoryRepository {
    suspend fun getCategoryAll(): Flow<Resource<CategoryListModel>>
}