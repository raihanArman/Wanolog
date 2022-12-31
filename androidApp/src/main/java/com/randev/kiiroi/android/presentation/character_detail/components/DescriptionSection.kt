package com.randev.kiiroi.android.presentation.character_detail

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.domain.model.CharacterDetailModel
import com.randev.movieapp_kmm.android.composable.components.image.BaseImageView
import com.randev.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.kiiroi.android.R
import com.randev.kiiroi.android.composable.components.button.BackButton
import com.randev.kiiroi.android.utils.emptyString
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 28/11/22
 */
@Composable
fun DescriptionSection(
    content: CharacterDetailModel,
    onBack: () -> Unit
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
                url = content.data.attributes.image.original
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
                url = content.data.attributes.image.original
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)) {
                Row {
                    BackButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White.copy(0.5f))
                            .padding(5.dp),
                        onClick = onBack
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
                text = content.data.attributes.canonicalName,
                style = MovieAppTheme.typography.bold,
                color = Color.White,
                fontSize = 26.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                textAlign = TextAlign.Center
            )
            VerticalSpacer(height = 5.dp)
            if (content.data.attributes.otherNames.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    content.data.attributes.otherNames.forEachIndexed { index, s ->
                        s?.let { name ->
                            Text(
                                text = name + if (index != content.data.attributes.otherNames.size - 1) ", " else emptyString(),
                                style = MovieAppTheme.typography.medium,
                                color = Color.Gray,
                                fontSize = 14.sp,
                            )
                        }
                    }
                }
            }

            if (content.voices.isNotEmpty()) {
                VerticalSpacer(height = 20.dp)

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BaseImageView(
                        url = content.voices[0].image.original,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(40.dp),
                        contentScale = ContentScale.Crop
                    )
                    HorizontalSpacer(width = 10.dp)
                    Text(
                        text = content.voices[0].name,
                        color = Color.White,
                        style = MovieAppTheme.typography.medium,
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