package com.ewalabs.data.mapper

import com.ewalabs.core.arch.BaseMapper
import com.ewalabs.domain.model.QuoteFavoriteModel
import com.randev.wanolog.db.QuoteFavoriteEntity

/**
 * @author Raihan Arman
 * @date 26/12/22
 */
class QuoteFavoriteMapper: BaseMapper<QuoteFavoriteEntity, QuoteFavoriteModel>() {
    override fun map(value: QuoteFavoriteEntity): QuoteFavoriteModel {
        return QuoteFavoriteModel(
            quote = value.quote,
            anime = value.anime,
            character = value.character,
            backgroundColor = value.backgroundColor.toLong()
        ).apply {
            status = true
        }
    }
}