package com.randev.kiiroi.android.presentation.manga_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.domain.model.CategoryModel
import com.randev.domain.model.MangaDetailModel
import com.randev.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.kiiroi.android.R
import com.randev.kiiroi.android.composable.components.image.GridImageLayout
import com.randev.kiiroi.android.composable.components.progressCircular.ProgressCircularComponent
import com.randev.kiiroi.android.composable.components.section.CategorySection
import com.randev.kiiroi.android.composable.components.section.RelatedSection
import com.randev.kiiroi.android.presentation.anime_detail.components.ReviewSection
import com.randev.kiiroi.android.presentation.manga_detail.composable.DescriptionSection
import com.randev.kiiroi.android.presentation.manga_detail.composable.StatsSection
import com.randev.kiiroi.android.presentation.review_manga.ReviewsMangaScreen
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 27/11/22
 */

@Composable
fun MangaDetailScreen(
    viewModel: MangaDetailViewModel = getViewModel()
) {
    val state by viewModel.observeDetailState.collectAsState()
    val isFavorite = viewModel.isFavorite

    state.data?.let { content ->
        ContentDetail(
            content = content,
            onClickCharacter = viewModel::onNavigateToCharactersClicked,
            onBack = viewModel::onBackScreen,
            onClickRelated = viewModel::onNavigateToDetailsClicked,
            onClickCategory = viewModel::onNavigateToMangaByCategoryClicked,
            onClickReviewMore = viewModel::openReviewBottomSheet,
            onClickFavorite = viewModel::insertDeleteFavorite,
            isFavorite = { isFavorite }
        )
    }
    if (state.isLoading) {
        ProgressCircularComponent(modifier = Modifier.fillMaxSize())
    }

    viewModel.mangaId?.let {
        ReviewsMangaScreen(
            sheetHandler = viewModel.sheetHandler,
            mangaId = it
        )
    }
}


@Composable
fun ContentDetail(
    content: MangaDetailModel,
    onClickCharacter: () -> Unit,
    onClickRelated: (String) -> Unit,
    onBack: () -> Unit,
    onClickCategory: (CategoryModel) -> Unit,
    onClickReviewMore: () -> Unit,
    onClickFavorite: (MangaDetailModel) -> Unit,
    isFavorite: () -> Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MovieAppTheme.colors.colorPrimary)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                DescriptionSection(
                    content = content,
                    onBack = onBack,
                    onClickFavorite = onClickFavorite,
                    isFavorite = isFavorite
                )
            }
            item {
                CategorySection(
                    categories = content.categories,
                    onClick = onClickCategory
                )
            }
            item {
                ChapterCount(content)
            }
            item {
                StatsSection(data = content)
            }
            if (content.reviews.isNotEmpty()) {
                item {
                    ReviewSection(data = content.reviews, onClickReviewAll = onClickReviewMore)
                }
            }
            if (content.characters.isNotEmpty()) {
                item {
                    CharacterSection(
                        content = content,
                        onClickCharacter = onClickCharacter
                    )
                }
            }
            if (content.relates.isNotEmpty()) {
                item {
                    RelatedSection(data = content.relates) {
                        onClickRelated(it)
                    }
                }
            }
        }
    }
}


@Composable
fun ChapterCount(content: MangaDetailModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_collections_bookmark_24),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier
                .size(50.dp)
        )
        HorizontalSpacer(width = 15.dp)
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "${content.data.attributes.chapterCount} Chapters",
                fontSize = 14.sp,
                color = MovieAppTheme.colors.colorAccent,
                style = MovieAppTheme.typography.medium
            )
            Text(
                text = "${content.data.attributes.volumeCount} volumes",
                fontSize = 14.sp,
                color = Color.Gray,
                style = MovieAppTheme.typography.medium
            )
        }
    }
}

@Composable
fun CharacterSection(content: MangaDetailModel, onClickCharacter: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        Text(
            text = "Characters",
            fontSize = 20.sp,
            color = Color.White,
            style = MovieAppTheme.typography.bold
        )

        VerticalSpacer(height = 10.dp)
        GridImageLayout(
            url = content.characters.map { it.image.original },
            modifier = Modifier
                .border(1.dp, Color.Gray, RoundedCornerShape(5))
                .clip(RoundedCornerShape(5))
                .size(200.dp),
            onClick = {
                onClickCharacter()
            }
        )
    }
}