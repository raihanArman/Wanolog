package com.randev.domain.model

import com.randev.core.arch.BaseModel

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
data class QuoteListModel(
    val data: List<QuoteModel>
): BaseModel(){
    data class QuoteModel(
        val backgroundColor: Long,
        val anime: String,
        val character: String,
        val quote: String,
        var isFavorite: Boolean = false,
    )
}
