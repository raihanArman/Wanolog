package com.randev.data.mapper

import com.randev.core.arch.BaseMapper
import com.randev.domain.model.AnimeFavoriteModel
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