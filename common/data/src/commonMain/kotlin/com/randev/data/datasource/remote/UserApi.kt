package com.randev.data.datasource.remote

import com.randev.data.response.UserListResponse
import com.randev.preferences.Preferences
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
class UserApi(
    private val ktor: HttpClient,
): UserApiClient {
    override suspend fun getCurrentUser(accessToken: String): UserListResponse {
        return ktor.get("api/edge/users") {
            parameter("filter[self]", true)
            println("Access Token -----> $accessToken")

            if (accessToken.isNotEmpty()) {
                headers {
                    header("Authorization", "Bearer $accessToken")
                }
            }
        }.body()
    }
}