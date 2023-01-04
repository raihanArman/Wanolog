package com.ewalabs.data.datasource.remote

import com.ewalabs.data.response.LoginResponse

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