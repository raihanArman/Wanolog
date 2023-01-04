package com.ewalabs.data.datasource.pref

import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
interface AuthPreferences {
    suspend fun getAccessToken(): Flow<String>
    suspend fun setAccessToken(accessToken: String)
}