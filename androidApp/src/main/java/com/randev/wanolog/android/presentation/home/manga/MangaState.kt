package com.randev.wanolog.android.presentation.home.manga

import com.randev.domain.model.AnimeListModel
import com.randev.domain.model.CategoryListModel
import com.randev.domain.model.MangaListModel

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
data class MangaState(
    val allData: List<MangaListModel.MangaModel>? = emptyList(),
    val trendingData: List<MangaListModel.MangaModel>? = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)