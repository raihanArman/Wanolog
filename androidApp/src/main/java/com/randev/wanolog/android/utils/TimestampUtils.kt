package com.randev.wanolog.android.utils

import java.util.*

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
fun String.toTimestamp(): Long {
    val parts = split("-")
    val cal = GregorianCalendar(parts[0].toInt(), parts[1].toInt(), parts[2].toInt())
    return cal.timeInMillis
}

/**
 * Assumes this long is a UNIX timestamp and strips it of its hour, minute, second, and millisecond
 * values, then returns the resulting timestamp.
 */
fun Long.stripToDate(): Long {
    val cal = GregorianCalendar()
    cal.timeInMillis = this
    return cal.stripToDate().timeInMillis
}

/**
 * Strips this calendar of its hour, minute, second, and millisecond values, then returns the
 * resulting Calendar object.
 */
fun Calendar.stripToDate(): Calendar {
    set(Calendar.HOUR_OF_DAY, 0)
    set(Calendar.HOUR, 0)
    set(Calendar.MINUTE, 0)
    set(Calendar.SECOND, 0)
    set(Calendar.MILLISECOND, 0)
    return this
}
