package com.ewalabs.data.datasource.local

import com.ewalabs.wanolog.db.WanologDatabase
import com.randev.wanolog.db.AnimeFavoriteEntity

/**
 * @author Raihan Arman
 * @date 22/12/22
 */
class AnimeFavoriteDataSourceImpl(
    private val database: WanologDatabase
): AnimeFavoriteDataSource {
    private val queries = database.animeFavoriteQueries

    override fun getFavoriteAll(): List<AnimeFavoriteEntity> {
        return queries.selectAll().executeAsList()
    }

    override fun getFavoriteById(id: Long): AnimeFavoriteEntity? {
        return queries.selectById(id).executeAsOneOrNull()
    }

    override suspend fun deleteFavoriteById(id: Long): Long {
        queries.deleteById(id)
        return queries.selectChanges().executeAsOne()
    }

    override suspend fun deleteFavoriteAll(): Long {
        queries.deleteAll()
        return queries.selectChanges().executeAsOne()
    }

    override suspend fun insertFavorite(entity: AnimeFavoriteEntity): Long {
        queries.insertItem(
            entity.id,
            entity.title,
            entity.poster,
            entity.rate
        )
        val id = queries.selectLastInsertedRowId().executeAsOne()
        return id
    }
}