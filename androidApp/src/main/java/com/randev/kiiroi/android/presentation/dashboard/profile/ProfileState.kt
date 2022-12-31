package com.randev.kiiroi.android.presentation.dashboard.profile

import com.randev.domain.model.AnimeFavoriteModel
import com.randev.domain.model.MangaFavoriteModel
import com.randev.domain.model.QuoteFavoriteModel
import com.randev.domain.model.UserModel

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
