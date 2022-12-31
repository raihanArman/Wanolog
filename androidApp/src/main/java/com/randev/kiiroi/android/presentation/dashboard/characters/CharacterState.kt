package com.randev.kiiroi.android.presentation.dashboard.characters

import com.randev.domain.model.CharacterListModel

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
data class CharacterState(
    val data: List<CharacterListModel.CharacterModel>? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)