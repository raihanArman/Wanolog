package com.ewalabs.kiiroi.composable.components.button

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ewalabs.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme

/**
 * @author Raihan Arman
 * @date 24/11/22
 */
@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier.fillMaxWidth(),
    text: String,
    onClick: () -> Unit,
    isLoading: (() -> Boolean)? = null
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = KiiroiAppTheme.colors.colorAccent,
            contentColor = Color.Blue
        ),
        onClick = onClick
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            if (isLoading != null) {
                AnimatedVisibility(visible = isLoading.invoke()) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(24.dp),
                        color = Color.Black
                    )
                    HorizontalSpacer(width = 30.dp)
                }
            }
            Text(
                text = text,
                fontSize = 16.sp,
                style = KiiroiAppTheme.typography.medium,
                color = Color.Black
            )
        }
    }
}