package com.randev.wanolog.android.presentation.manga_detail.composable

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.domain.model.AnimeDetailModel
import com.randev.domain.model.MangaDetailModel
import com.randev.movieapp_kmm.android.composable.components.image.BaseImageView
import com.randev.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.R
import com.randev.wanolog.android.composable.components.button.BackButton
import com.randev.wanolog.android.composable.components.icon.FavoriteIcon
import com.randev.wanolog.android.utils.releaseSummary
import com.randev.wanolog.android.utils.typeManga
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 27/11/22
 */

@Composable
fun DescriptionSection(
    content: MangaDetailModel,
    onBack: () -> Unit,
    isFavorite: () -> Boolean,
    onClickFavorite: (MangaDetailModel) -> Unit
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    val coroutineScope = rememberCoroutineScope()
    val rotate = remember { Animatable(0f) }
    val context = LocalContext.current

    Box {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentAlignment = Alignment.Center
        ) {
            BaseImageView(
                modifier = Modifier
                    .fillMaxSize()
                    .blur(20.dp),
                contentScale = ContentScale.Crop,
                url = content.data.attributes.posterImage.original
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colorStops = arrayOf(
                                Pair(0.4f, Color.Transparent),
                                Pair(0.9f, MovieAppTheme.colors.colorPrimary)
                            )
                        )
                    )
            )
            BaseImageView(
                modifier = Modifier
                    .width(170.dp)
                    .height(230.dp),
                contentScale = ContentScale.Crop,
                url = content.data.attributes.posterImage.original
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BackButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White.copy(0.5f))
                            .padding(5.dp),
                        onClick = onBack
                    )
                    FavoriteIcon(
                        isFavorite = isFavorite(),
                        onClickFavorite = {
                            onClickFavorite(content)
                        }
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)
        ) {
            VerticalSpacer(height = 320.dp)
            Text(
                text = content.data.attributes.titles.enJp,
                style = MovieAppTheme.typography.bold,
                color = Color.White,
                fontSize = 26.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .horizontalScroll(rememberScrollState()),
            ) {
                Text(
                    text = content.data.attributes.mangaType.typeManga(context),
                    style = MovieAppTheme.typography.medium,
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                if (content.data.attributes.startDate.isNotEmpty()) {
                    HorizontalSpacer(width = 8.dp)
                    Divider(
                        color = Color.Gray.copy(0.5f),
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                    HorizontalSpacer(width = 8.dp)
                    Text(
                        text = releaseSummary(
                            context,
                            content.data.attributes.startDate,
                            content.data.attributes.endDate
                        ),
                        style = MovieAppTheme.typography.medium,
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }

                if (content.data.attributes.ageRatingGuide.isNotEmpty() || content.data.attributes.ageRating.isNotEmpty()) {
                    HorizontalSpacer(width = 8.dp)
                    Divider(
                        color = Color.Gray.copy(0.5f),
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )

                    HorizontalSpacer(width = 8.dp)
                    Text(
                        text = content.data.attributes.ageRatingGuide.ifEmpty { content.data.attributes.ageRating },
                        style = MovieAppTheme.typography.medium,
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
            }

            VerticalSpacer(height = 20.dp)
            Text(
                text = content.data.attributes.description,
                style = MovieAppTheme.typography.medium,
                color = Color.White,
                fontSize = 14.sp,
                maxLines = if (!expanded) 4 else 20,
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioLowBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
            )
            VerticalSpacer(height = 10.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = if (expanded) "Show less" else "Read more",
                    color = Color.White
                )
                IconButton(
                    modifier = Modifier
                        .size(24.dp),
                    onClick = {
                        coroutineScope.launch {
                            rotate.animateTo(
                                targetValue = if (!expanded) 0f else 180f,
                            )
                        }

                        expanded = !expanded
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                        contentDescription = null,
                        modifier = Modifier
                            .rotate(degrees = rotate.value),
                        tint = Color.White
                    )
                }


            }
        }
    }
}