package com.ewalabs.kiiroi.composable.components.header

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ewalabs.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme
import com.ewalabs.kiiroi.composable.components.button.BackButton

/**
 * @author Raihan Arman
 * @date 24/11/22
 */
@Composable
fun HeaderWithBack(
    modifier: Modifier = Modifier,
    headerText: String,
    onBackClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackButton(
            onClick = onBackClick
        )
        HorizontalSpacer(width = 10.dp)
        Text(
            text = headerText,
            fontSize = 24.sp,
            color = Color.White,
            style = KiiroiAppTheme.typography.bold
        )
    }
}