package com.ewalabs.domain.model

import com.ewalabs.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
data class UserListModel(
    val data: List<UserModel>,
): BaseModel()