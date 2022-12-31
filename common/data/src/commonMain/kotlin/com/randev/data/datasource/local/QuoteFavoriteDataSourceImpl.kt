package com.randev.data.datasource.local

import com.randev.wanolog.db.QuoteFavoriteEntity
import com.randev.wanolog.db.WanologDatabase

/**
 * @author Raihan Arman
 * @date 22/12/22
 */
class QuoteFavoriteDataSourceImpl(
    private val database: WanologDatabase
): QuoteFavoriteDataSource {
    private val queries = database.quoteFavoriteQueries

    override fun getFavoriteAll(): List<QuoteFavoriteEntity> {
        return queries.selectAll().executeAsList()
    }

    override fun getFavoriteByQuote(quote: String): QuoteFavoriteEntity? {
        return queries.selectByQuote(quote).executeAsOneOrNull()
    }

    override suspend fun deleteFavoriteByQuote(quote: String): Long {
        queries.deleteByQuote(quote)
        return queries.selectChanges().executeAsOne()
    }

    override suspend fun deleteFavoriteAll(): Long {
        queries.deleteAll()
        return queries.selectChanges().executeAsOne()
    }

    override suspend fun insertFavorite(entity: QuoteFavoriteEntity): Long {
        queries.insertItem(
            entity.quote,
            entity.anime,
            entity.character,
            entity.backgroundColor
        )
        val id = queries.selectLastInsertedRowId().executeAsOne()
        return id
    }
}