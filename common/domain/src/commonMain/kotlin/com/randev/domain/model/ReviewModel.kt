package com.randev.domain.model

import com.randev.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
data class ReviewModel(
    val id: String,
    val content: String,
    val rating: Double,
    val username: String,
    val userId: String,
    val avatar: CoverImageModel
): BaseModel()