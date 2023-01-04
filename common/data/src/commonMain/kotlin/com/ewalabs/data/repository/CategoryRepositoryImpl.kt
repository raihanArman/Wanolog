package com.ewalabs.data.repository

import com.ewalabs.core.wrapper.NetworkResource
import com.ewalabs.core.wrapper.Resource
import com.ewalabs.data.datasource.remote.CategoryApiClient
import com.ewalabs.data.mapper.CategoryListMapper
import com.ewalabs.domain.model.CategoryListModel
import com.ewalabs.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

class CategoryRepositoryImpl(
    private val mapper: CategoryListMapper,
    private val api: CategoryApiClient
): CategoryRepository {
    override suspend fun getCategoryAll(): Flow<Resource<CategoryListModel>> {
        return object : NetworkResource<CategoryListModel>() {
            override suspend fun remoteFetch(): CategoryListModel {
                val request = api.fetchCategoryAll()
                return mapper.map(request)
            }
        }.asFlow()
    }
}