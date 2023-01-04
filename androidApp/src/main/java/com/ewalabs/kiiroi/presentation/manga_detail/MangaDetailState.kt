package com.ewalabs.kiiroi.presentation.manga_detail

import com.ewalabs.domain.model.MangaDetailModel

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
data class MangaDetailState(
    val data: MangaDetailModel? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)