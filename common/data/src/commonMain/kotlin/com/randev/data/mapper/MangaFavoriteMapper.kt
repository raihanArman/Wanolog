package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.domain.model.AnimeFavoriteModel
import com.randev.domain.model.MangaFavoriteModel
import com.randev.wanolog.db.AnimeFavoriteEntity
import com.randev.wanolog.db.MangaFavoriteEntity

/**
 * @author Raihan Arman
 * @date 26/12/22
 */
class MangaFavoriteMapper: BaseMapper<MangaFavoriteEntity, MangaFavoriteModel>() {
    override fun map(value: MangaFavoriteEntity): MangaFavoriteModel {
        return MangaFavoriteModel(
            id = value.id.toInt(),
            title = value.title,
            poster = value.poster,
            rate = value.rate.toInt()
        )
    }
}