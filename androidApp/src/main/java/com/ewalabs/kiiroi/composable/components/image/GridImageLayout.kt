package com.ewalabs.kiiroi.composable.components.image

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ewalabs.movieapp_kmm.android.composable.components.image.BaseImageView

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
@Composable
fun GridImageLayout(
    modifier: Modifier = Modifier,
    url: List<String>,
    divider: Dp = 2.dp,
    onClick: (() -> Unit?)? = null
) {
    if (url.isNotEmpty()) {

        ImageDrawLayout(
            modifier = modifier
                .clickable {
                    onClick?.invoke()
                },
            divider = divider,
            itemCount = url.size
        ) {
            url.forEach {
//                Image(
//                    modifier = Modifier.layoutId("Icon"),
//                    painter = painterResource(id = it),
//                    contentDescription = "Icon",
//                    contentScale = ContentScale.Crop,
//                )
                BaseImageView(
                    modifier = Modifier.layoutId("Icon"),
                    url = it,
                    contentScale = ContentScale.Crop,
                )
            }

            if (url.size > 4) {
                val carry = url.size - 3
                Box(
                    modifier = Modifier.layoutId("Text"),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "+$carry", fontSize = 20.sp, color = Color.Gray)
                }
            }
        }
    }
}