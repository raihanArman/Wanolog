package com.ewalabs.data.datasource.local

import com.ewalabs.wanolog.db.WanologDatabase
import com.randev.wanolog.db.MangaFavoriteEntity

/**
 * @author Raihan Arman
 * @date 22/12/22
 */
class MangaFavoriteDataSourceImpl(
    private val database: WanologDatabase
): MangaFavoriteDataSource {
    private val queries = database.mangaFavoriteQueries

    override fun getFavoriteAll(): List<MangaFavoriteEntity> {
        return queries.selectAll().executeAsList()
    }

    override fun getFavoriteById(id: Long): MangaFavoriteEntity? {
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

    override suspend fun insertFavorite(entity: MangaFavoriteEntity): Long {
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