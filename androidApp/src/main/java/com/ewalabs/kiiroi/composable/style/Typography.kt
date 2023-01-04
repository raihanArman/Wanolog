package com.ewalabs.kiiroi.composable.style

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp
import com.ewalabs.kiiroi.R

/**
 * @author Raihan Arman
 * @date 12/10/22
 */

object KiiroiComposeFonts {
    val regular : Font = Font(R.font.sf_pro_text_regular)
    val bold : Font = Font(R.font.sf_pro_text_bold)
    val medium : Font = Font(R.font.sf_pro_text_medium)
    val light : Font = Font(R.font.sf_pro_text_light)
}

@Immutable
data class KiiroiComposeTypography(
    override val medium: TextStyle = TextStyle(
        fontFamily = KiiroiComposeFonts.medium.toFontFamily(),
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        color = Colors.white
    ),
    override val bold: TextStyle = TextStyle(
        fontFamily = KiiroiComposeFonts.bold.toFontFamily(),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = Colors.white
    ),
    override val light: TextStyle = TextStyle(
        fontFamily = KiiroiComposeFonts.light.toFontFamily(),
        fontSize = 14.sp,
        fontWeight = FontWeight.Light,
        color = Colors.white
    ),
    override val normal: TextStyle = TextStyle(
        fontFamily = KiiroiComposeFonts.regular.toFontFamily(),
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = Colors.white
    )
): BaseKiiroiComposeTypography()