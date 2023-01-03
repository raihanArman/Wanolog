package com.randev.domain.model

import com.randev.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 16/11/22
 */
data class TitlesModel(
    val en: String,
    val enJp: String,
    val enUs: String,
    val jaJp: String
): BaseModel()