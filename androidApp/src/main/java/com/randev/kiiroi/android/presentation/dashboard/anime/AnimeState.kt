package com.randev.kiiroi.android.presentation.dashboard.anime

import com.randev.domain.model.AnimeListModel

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