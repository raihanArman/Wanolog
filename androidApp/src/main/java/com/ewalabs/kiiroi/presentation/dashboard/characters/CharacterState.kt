package com.ewalabs.kiiroi.presentation.dashboard.characters

import com.ewalabs.domain.model.CharacterListModel

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
data class CharacterState(
    val data: List<CharacterListModel.CharacterModel>? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)