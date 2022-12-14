package com.ewalabs.kiiroi.composable.components.button

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
@Composable
fun TextButtonCustom(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = KiiroiAppTheme.colors.colorAccent,
            style = KiiroiAppTheme.typography.bold
        )
    }
}