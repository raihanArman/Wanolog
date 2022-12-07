package com.randev.wanolog.android.presentation.dashboard.post.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.domain.model.PostListModel
import com.randev.movieapp_kmm.android.composable.components.image.BaseImageView
import com.randev.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.composable.components.text.HtmlText
import com.randev.wanolog.android.utils.toTimezoneDateToRangeTime

/**
 * @author Raihan Arman
 * @date 07/12/22
 */

@Composable
fun ItemPost(
    data: PostListModel.PostModel
) {
    Surface(
        color = Color.White.copy(alpha = 0.1f),
        modifier = Modifier
            .animateContentSize()
    ) {
        Column(
            modifier = Modifier
        ) {
            UserPost(data = data)
            VerticalSpacer(height = 10.dp)
            if (data.upload.isNotEmpty()) {
                BaseImageView(
                    url = data.upload[0].contentUrl,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    contentScale = ContentScale.Crop
                )
                VerticalSpacer(height = 20.dp)
            }

            DescriptionPost(html = data.attributes.contentFormatted)

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                color = MovieAppTheme.colors.colorPrimary
            ) {

            }
        }
    }
}

@Composable
fun DescriptionPost(
    html: String
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier
        .padding(start = 10.dp, end = 10.dp)) {
        HtmlText(
            html = html,
            maxLines = if (expanded) Int.MAX_VALUE else 5,
            overflow = TextOverflow.Ellipsis,
            onClick = {
                expanded = !expanded
            }
        )
    }
}

@Composable
fun UserPost(
    data: PostListModel.PostModel,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp, end = 10.dp, start = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BaseImageView(
            url = data.user[0].avatar?.original.orEmpty(),
            modifier = Modifier
                .clip(CircleShape)
                .size(25.dp),
            contentScale = ContentScale.Crop
        )
        HorizontalSpacer(width = 10.dp)
        Column(
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = data.user[0].name,
                color = Color.White,
                style = MovieAppTheme.typography.medium,
                fontSize = 11.sp
            )
            Text(
                text = data.attributes.createdAt.toTimezoneDateToRangeTime(),
                color = Color.White,
                style = MovieAppTheme.typography.light,
                fontSize = 8.sp
            )
        }
    }
}