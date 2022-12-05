package com.randev.domain.repository

import com.randev.core.wrapper.Resource
import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.LoginModel
import com.randev.domain.model.UserListModel
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
}