package com.ewalabs.movieapp_kmm.android.composable.style

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.ewalabs.movieapp_kmm.android.composable.utils.asDisabledColor

/**
 * @author Raihan Arman
 * @date 12/10/22
 */

object Colors {
    val whiteaa: Color = Color(0xFFD864BB)
    val white: Color = Color(0xFFFFFFFF)
    val black: Color = Color(0xFF000000)
    val white2: Color = Color(0xFFC2C2C2)
    val raisinBlack: Color = Color(0xFF222E3F)
    val charlestonGreen: Color = Color(0xFF222E3F)
    val sunGlow: Color = Color(0xFFFFD130)
    val sunGlow2: Color = Color(0xFFFF9130)
    val transparent: Color = Color(0xFF00000000)
    val red: Color = Color.Red
    val greenNotification = Color(0xff6FCF97)
    val redNotification = Color(0xffEB5757)
}

@Immutable
data class MovieComposeColorsDark(
    override val colorPrimary: Color = Colors.charlestonGreen,
    override val colorAccent: Color = Colors.sunGlow,
    override val colorPrimaryDark: Color = Colors.black,
    override val colorTextPrimary: Color = Colors.white,
    override val colorTextSecondary: Color = Colors.white.asDisabledColor()
) : BaseMovieComposeColors()


@Immutable
data class MovieComposeColorsLight(
    override val colorPrimary: Color = Colors.charlestonGreen,
    override val colorAccent: Color = Colors.sunGlow,
    override val colorPrimaryDark: Color = Colors.black,
    override val colorTextPrimary: Color = Colors.white,
    override val colorTextSecondary: Color = Colors.white.asDisabledColor()
) : BaseMovieComposeColors()