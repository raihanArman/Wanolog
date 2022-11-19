package com.randev.wanolog.android.presentation.home

import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CategoryListModel

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
data class HomeState(
    val categoryData: List<CategoryListModel.CategoryModel>? = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)