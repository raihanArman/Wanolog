package com.randev.wanolog.android.composable.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme

/**
 * @author Raihan Arman
 * @date 24/11/22
 */
@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier.fillMaxWidth(),
    text: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MovieAppTheme.colors.colorAccent,
            contentColor = Color.Blue
        ),
        onClick = onClick
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            style = MovieAppTheme.typography.medium,
            color = Color.Black
        )
    }
}