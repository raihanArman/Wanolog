package com.randev.wanolog.android.presentation.manga_detail

import com.randev.domain.model.AnimeDetailModel
import com.randev.domain.model.MangaDetailModel

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
data class MangaDetailState(
    val data: MangaDetailModel? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)