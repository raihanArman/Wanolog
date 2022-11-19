package com.randev.data.repository

import com.randev.core.wrapper.NetworkResource
import com.randev.core.wrapper.Resource
import com.randev.data.datasource.remote.CategoryApiClient
import com.randev.data.mapper.CategoryListMapper
import com.randev.domain.model.CategoryListModel
import com.randev.domain.repository.CategoryRepository
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