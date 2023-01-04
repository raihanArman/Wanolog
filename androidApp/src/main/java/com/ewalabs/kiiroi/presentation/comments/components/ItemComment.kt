package com.ewalabs.kiiroi.presentation.comments.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ewalabs.domain.model.CommentListModel
import com.ewalabs.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.ewalabs.kiiroi.composable.components.card.DescriptionPost
import com.ewalabs.kiiroi.composable.components.card.UserPost
import com.ewalabs.kiiroi.utils.toTimezoneDateToRangeTime

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