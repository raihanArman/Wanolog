package com.randev.kiiroi.android.utils

/**
 * @author Raihan Arman
 * @date 22/11/22
 */

sealed class Screen(
    val route: String
) {
    object Dashboard: Screen("dashboard")
    object Anime: Screen("anime")
    object Manga: Screen("manga")
    object Post: Screen("post")
    object Quote: Screen("quote")
    object Account: Screen("account")
}