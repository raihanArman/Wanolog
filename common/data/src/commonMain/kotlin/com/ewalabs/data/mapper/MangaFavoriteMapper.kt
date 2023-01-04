package com.ewalabs.data.mapper

import com.ewalabs.core.arch.BaseMapper
import com.ewalabs.domain.model.MangaFavoriteModel
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
            rate = value.rate.toFloat().toInt()
        ).apply {
            status = true
        }
    }
}