package com.ewalabs.kiiroi.presentation.home

/**
 * @author Raihan Arman
 * @date 19/11/22
 */

enum class ContentType(val value: String) {
    ANIME("Anime"),
    MANGA("Manga")
}

enum class ContentStatus(val value: String) {
    TRENDING("Trending"),
    TOP_UPCOMING("Top Upcoming"),
    TOP_RATING("Top Rating"),
    POPULAR("Popular"),
}

fun contentStatusList() = listOf(
    ContentStatus.TRENDING,
    ContentStatus.TOP_UPCOMING,
    ContentStatus.TOP_RATING,
    ContentStatus.POPULAR
)