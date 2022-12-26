package com.randev.data.datasource.local

import com.randev.wanolog.db.AnimeFavoriteEntity
import com.randev.wanolog.db.QuoteFavoriteEntity

/**
 * @author Raihan Arman
 * @date 22/12/22
 */
interface QuoteFavoriteDataSource {
    fun getFavoriteAll(): List<QuoteFavoriteEntity>
    fun getFavoriteByQuote(quote: String): QuoteFavoriteEntity?
    suspend fun deleteFavoriteByQuote(quote: String): Long
    suspend fun deleteFavoriteAll(): Long
    suspend fun insertFavorite(entity: QuoteFavoriteEntity): Long
}