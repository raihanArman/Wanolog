package com.ewalabs.kiiroi.presentation.character_detail

import com.ewalabs.domain.model.CharacterDetailModel

/**
 * @author Raihan Arman
 * @date 28/11/22
 */
data class CharacterDetailState(
    val data: CharacterDetailModel? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)