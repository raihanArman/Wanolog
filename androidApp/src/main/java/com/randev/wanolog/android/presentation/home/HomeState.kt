package com.randev.wanolog.android.presentation.home

import com.randev.domain.model.AnimeListModel

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

data class HomeState(
    val allData: List<AnimeListModel.AnimeModel>? = emptyList(),
    val trendingData: List<AnimeListModel.AnimeModel>? = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)