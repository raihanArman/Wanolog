package com.ewalabs.kiiroi.android.presentation.anime_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ewalabs.domain.model.ReviewModel
import com.ewalabs.movieapp_kmm.android.composable.components.image.BaseImageView
import com.ewalabs.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.ewalabs.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme
import com.ewalabs.kiiroi.R

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
@Composable
fun ReviewItem(
    modifier: Modifier = Modifier,
    data: ReviewModel
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        verticalAlignment = Alignment.Top
    ) {
        BaseImageView(
            modifier = Modifier
                .clip(CircleShape)
                .size(30.dp),
            url = data.avatar.original,
            contentScale = ContentScale.Crop
        )
        HorizontalSpacer(width = 10.dp)
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = data.username,
                fontSize = 14.sp,
                style = KiiroiAppTheme.typography.bold,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text(
                    text = "${data.rating}",
                    fontSize = 14.sp,
                    style = KiiroiAppTheme.typography.medium,
                )
                VerticalSpacer(height = 8.dp)
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_star_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(15.dp),
                    tint = KiiroiAppTheme.colors.colorAccent
                )

            }
            VerticalSpacer(height = 10.dp)
            Text(
                text = data.content,
                fontSize = 14.sp,
                style = KiiroiAppTheme.typography.light,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}