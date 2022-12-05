package com.randev.wanolog.android.presentation.dashboard.profile

import com.randev.domain.model.UserModel

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
data class ProfileState(
    val isLogin: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val userModel: UserModel? = null
)
