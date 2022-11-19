package com.randev.domain.model

import com.randev.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

data class CategoryListModel(
    val data: List<CategoryModel>,
): BaseModel() {
    data class CategoryModel(
        val childCount: Int,
        val description: String,
        val slug: String,
        val title: String,
        val updatedAt: String
    )
}