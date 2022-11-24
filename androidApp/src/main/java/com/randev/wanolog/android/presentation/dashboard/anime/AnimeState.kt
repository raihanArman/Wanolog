package com.randev.wanolog.android.presentation.dashboard.anime

import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CategoryListModel

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

data class AnimeState(
    val allData: List<AnimeListModel.AnimeModel>? = null,
    val trendingData: List<AnimeListModel.AnimeModel>? = null,
    val topUpcomingData: List<AnimeListModel.AnimeModel>? = null,
    val topRatingData: List<AnimeListModel.AnimeModel>? = null,
    val popularData: List<AnimeListModel.AnimeModel>? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)