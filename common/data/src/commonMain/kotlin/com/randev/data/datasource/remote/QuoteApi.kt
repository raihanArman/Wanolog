package com.randev.data.datasource.remote

import com.randev.data.response.QuoteListResponseItem
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class QuoteApi(
    private val ktor: HttpClient
): QuoteApiClient {
    override suspend fun fetchQuotes(page: Int): List<QuoteListResponseItem> {
        return ktor.get("api/quotes") {
            parameter("page", page)
        }.body()
    }
}