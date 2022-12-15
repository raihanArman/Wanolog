package com.randev.domain.model

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
data class QuoteListModel(
    val data: List<QuoteModel>
){
    data class QuoteModel(
        val backgroundColor: Long,
        val anime: String,
        val character: String,
        val quote: String
    )
}
