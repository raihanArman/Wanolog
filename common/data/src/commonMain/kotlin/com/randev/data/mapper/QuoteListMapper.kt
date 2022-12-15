package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.core.colors
import com.randev.data.response.QuoteListResponseItem
import com.randev.domain.model.QuoteListModel

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class QuoteListMapper: BaseMapper<List<QuoteListResponseItem>, QuoteListModel>() {
    override fun map(value: List<QuoteListResponseItem>): QuoteListModel {
        return QuoteListModel(
            data = value.map {
                QuoteListModel.QuoteModel(
                    backgroundColor = colors.random(),
                    anime = it.anime.orEmpty(),
                    character = it.character.orEmpty(),
                    quote = it.quote.orEmpty()
                )
            } ?: emptyList()
        )
    }
}
