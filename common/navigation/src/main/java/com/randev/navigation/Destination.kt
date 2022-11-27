package com.randev.navigation

/**
 * @author Raihan Arman
 * @date 19/10/22
 */

sealed class Destination(protected val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{${it}}") }
        builder.toString()
    }

    sealed class NoArgumentsDestination(route: String) : Destination(route) {
        operator fun invoke(): String = route
    }

    object DashboardScreen : NoArgumentsDestination("dashboard")

    object AnimeDetailScreen : Destination("anime_detail", "anime_id") {
        const val ANIME_ID_KEY = "anime_id"
        operator fun invoke(id: String): String = route.appendParams(
            ANIME_ID_KEY to id
        )
    }

    object MangaDetailScreen : Destination("manga_detail", "manga_id") {
        const val MANGA_ID_KEY = "manga_id"
        operator fun invoke(id: String): String = route.appendParams(
            MANGA_ID_KEY to id
        )
    }

    object AnimeAllScreen : NoArgumentsDestination("anime_all")
    object MangaAllScreen : NoArgumentsDestination("manga_all")
    object SearchScreen : NoArgumentsDestination("search")
    object FavoriteScreen : NoArgumentsDestination("favorite")
}


internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)

    params.forEach {
        it.second?.toString()?.let { arg ->
            builder.append("/$arg")
        }
    }

    return builder.toString()
}