package com.ewalabs.domain.model

import com.ewalabs.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
data class RelatedModel(
    val id: String,
    val type: String,
    val cover: CoverImageModel,
    val titles: TitlesModel
): BaseModel()