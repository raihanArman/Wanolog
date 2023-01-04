package com.ewalabs.data.datasource.local

import com.randev.wanolog.db.AnimeFavoriteEntity

/**
 * @author Raihan Arman
 * @date 22/12/22
 */
interface AnimeFavoriteDataSource {
    fun getFavoriteAll(): List<AnimeFavoriteEntity>
    fun getFavoriteById(id: Long): AnimeFavoriteEntity?
    suspend fun deleteFavoriteById(id: Long): Long
    suspend fun deleteFavoriteAll(): Long
    suspend fun insertFavorite(entity: AnimeFavoriteEntity): Long
}