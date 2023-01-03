package com.randev.domain.model

import com.randev.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
data class ReviewListModel(
    val data: List<ReviewModel>
): BaseModel()