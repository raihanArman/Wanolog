package com.randev.kiiroi.android.utils

import android.content.Context
import com.randev.kiiroi.android.R

/**
 * @author Raihan Arman
 * @date 27/11/22
 */

enum class ReleaseStatus(val value: Int) {
    FUTURE(0), PRESENT(1), PAST(2)
}

fun releaseStatus(
    startDate: String,
    endDate: String?
): ReleaseStatus {
    var status = ReleaseStatus.PAST // PAST by default

    val now = System.currentTimeMillis()
    val start = startDate.toTimestamp() ?: 0
    val end = endDate?.toTimestamp() ?: now + 60000 // If doesn't exit, assume infinity. :kappa:

    if (start > now) {
        status = ReleaseStatus.FUTURE
    } else if (start < now && end > now) {
        status = ReleaseStatus.PRESENT
    } else if (end < now) {
        status = ReleaseStatus.PAST
    }

    return status
}

fun releaseSummary(
    context: Context,
    startDate: String,
    endDate: String?
): String {
    return when (releaseStatus(startDate, endDate)) {
        ReleaseStatus.FUTURE -> {
            context.getString(R.string.media_release_summary_anime_future)
        }
        ReleaseStatus.PRESENT -> {
            context.getString(R.string.media_release_summary_anime_present)
        }
        ReleaseStatus.PAST -> {
            context.getString(R.string.media_release_summary_anime_past)
        }
    }
}

fun String.typeAnime(
    context: Context
): String {
    return when (this) {
        "TV" -> context.getString(R.string.media_type_anime_tv)
        "special" -> context.getString(R.string.media_type_anime_special)
        "OVA" -> context.getString(R.string.media_type_anime_ova)
        "ONA" -> context.getString(R.string.media_type_anime_ona)
        "movie" -> context.getString(R.string.media_type_anime_movie)
        "music" -> context.getString(R.string.media_type_anime_music)
        else -> "?"
    } ?: this ?: "?"
}

fun String.typeManga(
    context: Context
): String {
    return when (this) {
        "manga" -> context.getString(R.string.media_type_manga_manga)
        "novel" -> context.getString(R.string.media_type_manga_novel)
        "manhua" -> context.getString(R.string.media_type_manga_manhua)
        "oneshot" -> context.getString(R.string.media_type_manga_oneshot)
        "doujin" -> context.getString(R.string.media_type_manga_doujin)
        else -> "?"
    } ?: this ?: "?"
}