package com.ewalabs.kiiroi.presentation.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme
import com.ewalabs.kiiroi.presentation.home.ContentType

/**
 * @author Raihan Arman
 * @date 19/11/22
 */

@Composable
fun ContentTypeItem(
    modifier: Modifier = Modifier,
    contentTypeSelected: ContentType,
    contentTypeCurrent: ContentType,
    onClick: () -> Unit
) {
    if (contentTypeSelected == contentTypeCurrent) {
        Surface(
            shape = CircleShape,
            color = Color.White.copy(0.1f),
            border = BorderStroke(1.dp, color = Color.White),
            modifier = modifier
                .clickable {
                    onClick()
                }
        ) {
            Text(
                text = contentTypeCurrent.value,
                color = Color.White,
                fontSize = 16.sp,
                style = KiiroiAppTheme.typography.medium,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 5.dp,
                    bottom = 5.dp
                )
            )
        }
    } else {
        Text(text = contentTypeCurrent.value,
            color = Color.White,
            fontSize = 16.sp,
            style = KiiroiAppTheme.typography.medium,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 5.dp,
                    bottom = 5.dp
                )
                .clickable {
                    onClick()
                }
        )
    }
}

@Preview
@Composable
fun PreviewContentType() {
    KiiroiAppTheme {
        Row() {
            ContentTypeItem(
                contentTypeCurrent = ContentType.ANIME,
                contentTypeSelected = ContentType.ANIME,
                onClick = {

                }
            )
            ContentTypeItem(
                contentTypeCurrent = ContentType.MANGA,
                contentTypeSelected = ContentType.ANIME,
                onClick = {

                }
            )
        }
    }
}