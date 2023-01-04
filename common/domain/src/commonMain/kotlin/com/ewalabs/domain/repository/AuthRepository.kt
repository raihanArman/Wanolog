package com.ewalabs.domain.repository

import com.ewalabs.core.wrapper.Resource
import com.ewalabs.domain.model.UserListModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
interface AuthRepository {
    suspend fun postLogin(
        username: String,
        password: String
    ): Flow<Resource<UserListModel>>

    suspend fun userIsLogin(): Flow<Boolean>

}