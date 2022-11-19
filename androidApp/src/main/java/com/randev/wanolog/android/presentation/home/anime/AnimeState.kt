package com.randev.wanolog.android.presentation.home.anime

import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CategoryListModel

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

data class AnimeState(
    val allData: List<AnimeListModel.AnimeModel>? = emptyList(),
    val trendingData: List<AnimeListModel.AnimeModel>? = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)