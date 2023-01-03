package com.randev.domain.model

import com.randev.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
data class CharacterModel(
    val id: String,
    val image: CoverImageModel,
    val name: String,
): BaseModel()