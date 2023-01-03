package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.core.colors
import com.randev.data.datasource.local.QuoteFavoriteDataSource
import com.randev.data.response.QuoteListResponseItem
import com.randev.domain.model.QuoteListModel

/**
 * @author Raihan Arman
 * @date 15/12/22
 */
class QuoteListMapper(
    private val favoriteDataSource: QuoteFavoriteDataSource
): BaseMapper<List<QuoteListResponseItem>, QuoteListModel>() {
    override fun map(value: List<QuoteListResponseItem>): QuoteListModel {
        return QuoteListModel(
            data = value.map {
                QuoteListModel.QuoteModel(
                    backgroundColor = colors.random(),
                    anime = it.anime.orEmpty(),
                    character = it.character.orEmpty(),
                    quote = it.quote.orEmpty(),
                ).apply {
                    val favorite = favoriteDataSource.getFavoriteByQuote(it.quote.orEmpty())
                    isFavorite = favorite != null
                }
            }
        ).apply {
            status = true
        }
    }
}
