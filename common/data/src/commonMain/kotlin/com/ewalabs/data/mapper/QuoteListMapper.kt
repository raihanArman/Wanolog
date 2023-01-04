package com.ewalabs.data.mapper

import com.ewalabs.core.arch.BaseMapper
import com.ewalabs.core.colors
import com.ewalabs.data.datasource.local.QuoteFavoriteDataSource
import com.ewalabs.data.response.QuoteListResponseItem
import com.ewalabs.domain.model.QuoteListModel

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
