package com.ewalabs.kiiroi.presentation.dashboard.profile

import com.ewalabs.domain.model.AnimeFavoriteModel
import com.ewalabs.domain.model.MangaFavoriteModel
import com.ewalabs.domain.model.QuoteFavoriteModel
import com.ewalabs.domain.model.UserModel

/**
 * @author Raihan Arman
 * @date 05/12/22
 */
data class ProfileState(
    val isLogin: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val userModel: UserModel? = null,
    val favAnimeList: List<AnimeFavoriteModel>? = null,
    val favMangaList: List<MangaFavoriteModel>? = null,
    val favQuoteList: List<QuoteFavoriteModel>? = null,
)
