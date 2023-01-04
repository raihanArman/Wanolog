package com.ewalabs.data.datasource.pref

import com.ewalabs.preferences.ACCESS_TOKEN_KEY
import com.ewalabs.preferences.Preferences
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
class AuthPreferencesImpl(
    private val preferences: Preferences
): AuthPreferences {

    override suspend fun getAccessToken(): Flow<String> {
        return preferences.getStringOrDefault(ACCESS_TOKEN_KEY, "")
    }

    override suspend fun setAccessToken(accessToken: String) {
        preferences.set(ACCESS_TOKEN_KEY, accessToken)
    }

}