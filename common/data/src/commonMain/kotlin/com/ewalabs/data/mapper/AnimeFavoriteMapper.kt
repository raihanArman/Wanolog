package com.ewalabs.data.mapper

import com.ewalabs.core.arch.BaseMapper
import com.ewalabs.domain.model.AnimeFavoriteModel
import com.randev.wanolog.db.AnimeFavoriteEntity

/**
 * @author Raihan Arman
 * @date 26/12/22
 */
class AnimeFavoriteMapper: BaseMapper<AnimeFavoriteEntity, AnimeFavoriteModel>() {
    override fun map(value: AnimeFavoriteEntity): AnimeFavoriteModel {
        return AnimeFavoriteModel(
            id = value.id.toInt(),
            title = value.title,
            poster = value.poster,
            rate = value.rate.toFloat().toInt()
        ).apply {
            status = true
        }
    }
}