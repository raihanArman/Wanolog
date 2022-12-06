package com.randev.data.repository

import com.randev.core.wrapper.NetworkResource
import com.randev.core.wrapper.Resource
import com.randev.data.datasource.pref.AuthPreferences
import com.randev.data.datasource.remote.AnimeApiClient
import com.randev.data.datasource.remote.AuthApiClient
import com.randev.data.datasource.remote.UserApiClient
import com.randev.data.mapper.AnimeDetailMapper
import com.randev.data.mapper.AnimeListMapper
import com.randev.data.mapper.UserListMapper
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.UserListModel
import com.randev.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
class AuthRepositoryImpl(
    private val mapper: UserListMapper,
    private val authApi: AuthApiClient,
    private val userApi: UserApiClient,
    private val authPreferences: AuthPreferences
): AuthRepository {
    override suspend fun postLogin(
        username: String,
        password: String
    ): Flow<Resource<UserListModel>> {
        return object : NetworkResource<UserListModel>() {
            override suspend fun remoteFetch(): UserListModel {
                val result = authApi.postLogin(username, password)
                if (result.accessToken != null) {
                    val accessTokenValue = result.accessToken
                    authPreferences.setAccessToken(accessTokenValue)

                    val currentUserResult = userApi.getCurrentUser(accessTokenValue)
                    return mapper.map(currentUserResult)
                } else {
                    throw Throwable("Email atau password salah")
                }
            }
        }.asFlow()
    }

    override suspend fun userIsLogin(): Flow<Boolean> {
        val isLogin = authPreferences.getAccessToken().map {
            it.isNotEmpty()
        }

        return isLogin
    }
}