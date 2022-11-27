package com.randev.wanolog.android.presentation.anime_detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.domain.model.ReviewModel
import com.randev.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.R

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
@Composable
fun ReviewSection(
    modifier: Modifier = Modifier,
    data: List<ReviewModel>,
    onClickReviewAll: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp, top = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            data.take(2).forEach {
                ReviewItem(data = it)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {
                        onClickReviewAll()
                    }
            ) {
                Text(
                    text = "All Reviews",
                    fontSize = 14.sp,
                    style = MovieAppTheme.typography.bold,
                    color = Color.Gray
                )
                HorizontalSpacer(width = 10.dp)
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                    modifier = Modifier
                        .size(16.dp),
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }
    }
}