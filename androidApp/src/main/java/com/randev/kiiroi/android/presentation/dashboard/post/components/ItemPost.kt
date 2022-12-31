package com.randev.kiiroi.android.presentation.dashboard.post.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.domain.model.PostListModel
import com.randev.movieapp_kmm.android.composable.components.image.BaseImageView
import com.randev.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.kiiroi.android.R
import com.randev.kiiroi.android.composable.components.card.DescriptionPost
import com.randev.kiiroi.android.composable.components.card.UserPost
import com.randev.kiiroi.android.utils.toTimezoneDateToRangeTime

/**
 * @author Raihan Arman
 * @date 07/12/22
 */

@Composable
fun ItemPost(
    data: PostListModel.PostModel,
    onClickComment: (String) -> Unit
) {
    Surface(
        color = Color.White.copy(alpha = 0.1f),
        modifier = Modifier
            .animateContentSize()
    ) {
        Column(
            modifier = Modifier
        ) {
            UserPost(
                name = data.user[0].name,
                image = data.user[0].avatar?.original.orEmpty(),
                rangeTime = data.attributes.createdAt.toTimezoneDateToRangeTime()
            )
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
            LikeCommentsCount(
                data = data,
                onClickComment = onClickComment
            )
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
fun LikeCommentsCount(data: PostListModel.PostModel, onClickComment: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
           Icon(
               painter = painterResource(id = R.drawable.ic_outline_thumb_up_24),
               contentDescription = null,
               modifier = Modifier.size(15.dp),
               tint = Color.Gray
           )
           HorizontalSpacer(width = 5.dp)
           Text(
               text = "${data.attributes.postLikesCount} likes",
               style = MovieAppTheme.typography.light,
               color = Color.Gray,
               fontSize = 11.sp
           )
        }
        HorizontalSpacer(width = 10.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable {
                    onClickComment(data.id)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_insert_comment_24),
                contentDescription = null,
                modifier = Modifier.size(15.dp),
                tint = Color.Gray
            )
            HorizontalSpacer(width = 5.dp)
            Text(
                text = "${data.attributes.commentsCount} comments",
                style = MovieAppTheme.typography.light,
                color = Color.Gray,
                fontSize = 11.sp
            )
        }
    }
}

