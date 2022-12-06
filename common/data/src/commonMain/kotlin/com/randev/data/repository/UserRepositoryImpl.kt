package com.randev.data.repository

import com.randev.core.wrapper.NetworkResource
import com.randev.core.wrapper.Resource
import com.randev.data.datasource.pref.AuthPreferences
import com.randev.data.datasource.remote.AuthApiClient
import com.randev.data.datasource.remote.UserApiClient
import com.randev.data.mapper.UserListMapper
import com.randev.domain.model.UserListModel
import com.randev.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 06/12/22
 */
class UserRepositoryImpl(
    private val mapper: UserListMapper,
    private val userApi: UserApiClient
): UserRepository {
    override suspend fun getCurrentUser(): Flow<Resource<UserListModel>> {
        return object : NetworkResource<UserListModel>() {
            override suspend fun remoteFetch(): UserListModel {
                val result = userApi.getCurrentUser()
                return mapper.map(result)
            }
        }.asFlow()
    }

}