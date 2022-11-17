package com.randev.wanolog.android.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.util.lerp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.randev.domain.model.AnimeListModel
import com.randev.movieapp_kmm.android.composable.components.image.BaseImageView
import kotlin.math.absoluteValue

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerWithTransition(
    modifier: Modifier = Modifier,
    data: List<AnimeListModel.AnimeModel>,
) {
    HorizontalPager(
        state = PagerState(
            pageCount = data.size,
            currentPage = 0,
            infiniteLoop = data.size != 1,
        ),
        modifier = modifier,
    ) { page ->
        Card(
            shape = RoundedCornerShape(5.dp),
            elevation = 10.dp,
            modifier = Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }

                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
                .width(120.dp)
                .height(190.dp)
        ) {

            BaseImageView(
                url = data[page].attributes.posterImage.original,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
            )

            Box(
                modifier = Modifier
                    .background(brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black)
                    ))
            )

        }
    }
}
