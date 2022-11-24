package com.randev.core

/**
 * @author Raihan Arman
 * @date 24/11/22
 */

enum class SortType(val value: String, val path: String) {
    RATING_RANK("Rating Rank", "-averageRating"),
    START_DATE("Start Date", "-startDate"),
    FAVORITE_COUNT("Favorite Count", "-favoritesCount"),
    NA("NA", ""),
}

fun listOfSort() = listOf(
    SortType.RATING_RANK,
    SortType.START_DATE,
    SortType.FAVORITE_COUNT,
)