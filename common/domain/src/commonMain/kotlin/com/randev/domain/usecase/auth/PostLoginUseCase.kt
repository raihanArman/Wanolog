package com.randev.domain.usecase.auth

import com.randev.core.wrapper.FlowUseCase
import com.randev.core.wrapper.Resource
import com.randev.domain.model.UserListModel
import com.randev.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
class PostLoginUseCase(
    private val repository: AuthRepository
): FlowUseCase<LoginRequest?, UserListModel>() {
    override suspend fun execute(parameters: LoginRequest?): Flow<Resource<UserListModel>> {
        return repository.postLogin(parameters!!.username, parameters.password)
    }
}

data class LoginRequest(
    val username: String,
    val password: String
)