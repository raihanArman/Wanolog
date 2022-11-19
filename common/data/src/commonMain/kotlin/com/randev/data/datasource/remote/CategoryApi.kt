package com.randev.data.datasource.remote

import com.randev.data.response.CategoryListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * @author Raihan Arman
 * @date 17/11/22
 */
class CategoryApi(
    private val ktor: HttpClient
): CategoryApiClient {
    override suspend fun fetchCategoryAll(): CategoryListResponse {
        return ktor.get("api/edge/categories") {
            parameter("page[limit]", 20)
        }.body()
    }
}