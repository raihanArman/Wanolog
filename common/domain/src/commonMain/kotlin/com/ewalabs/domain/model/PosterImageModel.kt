package com.ewalabs.domain.model

import com.ewalabs.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
data class PosterImageModel(
    val large: String,
    val medium: String,
    val original: String,
    val small: String,
    val tiny: String?
): BaseModel()
