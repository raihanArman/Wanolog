package com.randev.data.datasource.remote

import com.randev.data.response.AnimeDetailResponse
import com.randev.data.response.UserListResponse

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
interface UserApiClient {
    suspend fun getCurrentUser(accessToken: String = ""): UserListResponse
}