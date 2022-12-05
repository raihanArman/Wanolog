package com.randev.data.datasource.remote

import com.randev.data.response.LoginResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
class AuthApi(
    private val ktor: HttpClient
): AuthApiClient {
    override suspend fun postLogin(
        username: String,
        password: String,
    ): LoginResponse {
        return ktor.post("api/oauth/token") {
            parameter("grant_type", "password")
            parameter("username", username)
            parameter("password", password)
            parameter("client_id", "dd031b32d2f56c990b1425efe6c42ad847e7fe3ab46bf1299f05ecd856bdb7dd")
            parameter("client_secret", "54d7307928f63414defd96399fc31ba847961ceaecef3a5fd93144e960c0e151")
        }.body()
    }
}