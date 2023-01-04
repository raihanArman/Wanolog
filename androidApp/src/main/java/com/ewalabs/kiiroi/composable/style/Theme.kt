package com.ewalabs.kiiroi.composable.style

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

/**
 * @author Raihan Arman
 * @date 12/10/22
 */

@Composable
fun KiiroiAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val kiiroiComposeColors = if (darkTheme) KiiroiComposeColorsDark() else KiiroiComposeColorsLight()
    val kiiroiComposeTypography = KiiroiComposeTypography()
    
    CompositionLocalProvider(
        LocalMovieComposeColors provides kiiroiComposeColors,
        LocalMovieComposeTypography provides kiiroiComposeTypography
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object KiiroiAppTheme {
    val colors: BaseKiiroiComposeColors
        @Composable
        get() = LocalMovieComposeColors.current

    val typography: BaseKiiroiComposeTypography
        @Composable
        get() = LocalMovieComposeTypography.current
}