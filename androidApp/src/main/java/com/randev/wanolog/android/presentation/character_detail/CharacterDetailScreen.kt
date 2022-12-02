package com.randev.wanolog.android.presentation.character_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.randev.domain.model.AnimeDetailModel
import com.randev.domain.model.CharacterDetailModel
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.presentation.anime_detail.CharacterSection
import com.randev.wanolog.android.presentation.anime_detail.EpisodeCount
import com.randev.wanolog.android.presentation.anime_detail.components.CategorySection
import com.randev.wanolog.android.presentation.anime_detail.components.RelatedSection
import com.randev.wanolog.android.presentation.anime_detail.components.ReviewSection
import com.randev.wanolog.android.presentation.anime_detail.components.StatsSection
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 28/11/22
 */
@Composable
fun CharacterDetailScreen(
    viewModel: CharacterDetailViewModel = getViewModel()
) {
    val state by viewModel.observeCharDetail.collectAsState()

    state.data?.let { content ->
        ContentDetail(
            content = content,
            onBack = viewModel::onBackScreen,
        )
    }

}

@Composable
fun ContentDetail(
    content: CharacterDetailModel,
    onBack: () -> Unit
) {
   Box(
       modifier = Modifier
           .fillMaxSize()
           .background(MovieAppTheme.colors.colorPrimary)
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
                       onBack = onBack
                   )
               }
           }
       }
   }
}