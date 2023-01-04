package com.ewalabs.domain.model

import com.ewalabs.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
data class CharacterModel(
    val id: String,
    val image: CoverImageModel,
    val name: String,
): BaseModel()