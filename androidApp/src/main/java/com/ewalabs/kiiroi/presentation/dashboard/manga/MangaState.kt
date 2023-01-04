package com.ewalabs.kiiroi.presentation.dashboard.manga

import com.ewalabs.domain.model.MangaListModel

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
data class MangaState(
    val allData: List<MangaListModel.MangaModel>? = null,
    val trendingData: List<MangaListModel.MangaModel>? = null,
    val topUpcomingData: List<MangaListModel.MangaModel>? = null,
    val topRatingData: List<MangaListModel.MangaModel>? = null,
    val popularData: List<MangaListModel.MangaModel>? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)