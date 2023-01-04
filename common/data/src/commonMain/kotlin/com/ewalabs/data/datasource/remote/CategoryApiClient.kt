package com.ewalabs.data.datasource.remote

import com.ewalabs.data.response.CategoryListResponse

/**
 * @author Raihan Arman
 * @date 17/11/22
 */
interface CategoryApiClient {
    suspend fun fetchCategoryAll(): CategoryListResponse
}