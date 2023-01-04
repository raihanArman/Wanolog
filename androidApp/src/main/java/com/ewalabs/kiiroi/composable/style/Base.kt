package com.ewalabs.kiiroi.composable.style

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

/**
 * @author Raihan Arman
 * @date 12/10/22
 */

abstract class BaseKiiroiComposeColors {
    abstract val colorPrimary: Color
    abstract val colorAccent: Color
    abstract val colorPrimaryDark: Color
    abstract val colorTextPrimary: Color
    abstract val colorTextSecondary: Color
}

val LocalMovieComposeColors = staticCompositionLocalOf<BaseKiiroiComposeColors> {
    KiiroiComposeColorsDark()
    KiiroiComposeColorsLight()
}

abstract class BaseKiiroiComposeTypography {
    abstract val medium: TextStyle
    abstract val bold: TextStyle
    abstract val light: TextStyle
    abstract val normal: TextStyle
}

val LocalMovieComposeTypography = staticCompositionLocalOf<BaseKiiroiComposeTypography> {
    KiiroiComposeTypography()
}