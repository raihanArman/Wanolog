package com.randev.kiiroi.android.presentation.comments.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.randev.domain.model.CommentListModel
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.kiiroi.android.composable.components.card.DescriptionPost
import com.randev.kiiroi.android.composable.components.card.UserPost
import com.randev.kiiroi.android.utils.toTimezoneDateToRangeTime

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