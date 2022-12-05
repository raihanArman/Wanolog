package com.randev.data.datasource.remote

import com.randev.data.response.AnimeListResponse
import com.randev.data.response.LoginResponse

/**
 * @author Raihan Arman
 * @date 02/12/22
 */
interface AuthApiClient {
    suspend fun postLogin(
        username: String,
        password: String,
    ): LoginResponse
}