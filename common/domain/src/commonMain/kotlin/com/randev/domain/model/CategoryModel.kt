package com.randev.domain.model

import com.randev.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
data class CategoryModel(
    val id: String,
    val title: String,
): BaseModel()