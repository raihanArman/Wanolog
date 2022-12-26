package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.domain.model.AnimeFavoriteModel
import com.randev.domain.model.MangaFavoriteModel
import com.randev.domain.model.QuoteFavoriteModel
import com.randev.wanolog.db.AnimeFavoriteEntity
import com.randev.wanolog.db.MangaFavoriteEntity
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
            character = value.character
        )
    }
}