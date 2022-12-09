package com.randev.wanolog.android.presentation.comments.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.randev.domain.model.CommentListModel
import com.randev.movieapp_kmm.android.composable.components.image.BaseImageView
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.composable.components.card.DescriptionPost
import com.randev.wanolog.android.composable.components.card.UserPost
import com.randev.wanolog.android.presentation.dashboard.post.components.LikeCommentsCount
import com.randev.wanolog.android.utils.toTimezoneDateToRangeTime

/**
 * @author Raihan Arman
 * @date 09/12/22
 */
@Composable
fun ItemComment(
    modifier: Modifier = Modifier,
    data: CommentListModel.CommentModel
) {
    Column(
        modifier = modifier
            .animateContentSize(),
    ) {
        UserPost(
            name = data.user[0].name,
            image = data.user[0].avatar?.original.orEmpty(),
            rangeTime = data.attributes.createdAt.toTimezoneDateToRangeTime()
        )
        VerticalSpacer(height = 10.dp)

        DescriptionPost(html = data.attributes.contentFormatted)
//        LikeCommentsCount(data)
    }
}