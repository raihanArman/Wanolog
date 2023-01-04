package com.ewalabs.domain.model

import com.ewalabs.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
data class ReviewListModel(
    val data: List<ReviewModel>
): BaseModel()