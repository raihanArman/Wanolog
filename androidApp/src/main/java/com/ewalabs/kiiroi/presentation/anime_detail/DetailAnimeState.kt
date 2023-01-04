package com.ewalabs.kiiroi.presentation.anime_detail

import com.ewalabs.domain.model.AnimeDetailModel

/**
 * @author Raihan Arman
 * @date 26/11/22
 */
data class DetailAnimeState(
    val data: AnimeDetailModel? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
