package com.randev.data.datasource.remote

import com.randev.data.response.CategoryListResponse

/**
 * @author Raihan Arman
 * @date 17/11/22
 */
interface CategoryApiClient {
    suspend fun fetchCategoryAll(): CategoryListResponse
}