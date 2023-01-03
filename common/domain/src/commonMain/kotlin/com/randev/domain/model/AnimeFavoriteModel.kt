package com.randev.domain.model

import com.randev.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 23/10/22
 */

data class AnimeFavoriteModel(
    val id: Int,
    val title: String,
    val poster: String,
    val rate: Int
): BaseModel()