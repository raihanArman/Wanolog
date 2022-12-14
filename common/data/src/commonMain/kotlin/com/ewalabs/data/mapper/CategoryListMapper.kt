package com.ewalabs.data.mapper

import com.ewalabs.core.arch.BaseMapper
import com.ewalabs.data.response.CategoryListResponse
import com.ewalabs.domain.model.CategoryListModel

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

class CategoryListMapper: BaseMapper<CategoryListResponse, CategoryListModel>() {
    override fun map(value: CategoryListResponse): CategoryListModel {
        return CategoryListModel(
            data = value.data?.map {
                it.mapToModel()
            } ?: emptyList()
        ).apply {
            status = true
        }
    }
}

fun CategoryListResponse.Data?.mapToModel() = CategoryListModel.CategoryModel(
    childCount = this?.attributes?.childCount ?: 0,
    description = this?.attributes?.description.orEmpty(),
    slug = this?.attributes?.slug.orEmpty(),
    title = this?.attributes?.title.orEmpty(),
    updatedAt = this?.attributes?.updatedAt.orEmpty()
)