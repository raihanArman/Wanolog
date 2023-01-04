package com.ewalabs.data.datasource.remote

import com.ewalabs.data.response.UserListResponse

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
interface UserApiClient {
    suspend fun getCurrentUser(accessToken: String = ""): UserListResponse
}