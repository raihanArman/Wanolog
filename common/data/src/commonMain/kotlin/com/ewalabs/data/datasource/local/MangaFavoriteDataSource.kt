package com.ewalabs.data.datasource.local

import com.randev.wanolog.db.MangaFavoriteEntity


/**
 * @author Raihan Arman
 * @date 22/12/22
 */
interface MangaFavoriteDataSource {
    fun getFavoriteAll(): List<MangaFavoriteEntity>
    fun getFavoriteById(id: Long): MangaFavoriteEntity?
    suspend fun deleteFavoriteById(id: Long): Long
    suspend fun deleteFavoriteAll(): Long
    suspend fun insertFavorite(entity: MangaFavoriteEntity): Long
}