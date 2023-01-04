package com.ewalabs.kiiroi.presentation.character_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ewalabs.domain.model.CharacterDetailModel
import com.ewalabs.kiiroi.composable.style.KiiroiAppTheme
import com.ewalabs.kiiroi.composable.components.progressCircular.ProgressCircularComponent
import com.ewalabs.kiiroi.android.presentation.character_detail.DescriptionSection
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
    if (state.isLoading) {
        ProgressCircularComponent(modifier = Modifier.fillMaxSize())
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
           .background(KiiroiAppTheme.colors.colorPrimary)
   ) {
       Box(
           modifier = Modifier
               .fillMaxSize()
               .background(KiiroiAppTheme.colors.colorPrimary)
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