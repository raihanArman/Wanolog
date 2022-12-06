package com.randev.domain.usecase.auth

import com.randev.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 06/12/22
 */
class CheckUserLoginUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(): Flow<Boolean> {
        return repository.userIsLogin()
    }

}