package com.ewalabs.domain.model

import com.ewalabs.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 23/10/22
 */

data class QuoteFavoriteModel(
    val quote: String,
    val anime: String,
    val character: String,
    val backgroundColor: Long
): BaseModel()