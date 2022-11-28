package com.randev.wanolog.android.presentation.character_manga

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.randev.movieapp_kmm.android.composable.components.space.HorizontalSpacer
import com.randev.wanolog.android.composable.components.button.OutlineButtonCustom
import com.randev.wanolog.android.composable.components.header.HeaderWithBack
import com.randev.wanolog.android.composable.components.text_field.SearchTextField
import com.randev.wanolog.android.presentation.home.component.ItemCard
import com.randev.wanolog.android.utils.items
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 28/11/22
 */
@Composable
fun CharacterMangaScreen(
    viewModel: CharacterMangaViewModel = getViewModel()
) {

    val data = viewModel.characterPagination.collectAsLazyPagingItems()

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalArrangement = Arrangement.spacedBy(25.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        columns = GridCells.Fixed(2)
    ) {
        item(span = { GridItemSpan(2) }) {
            HeaderWithBack(
                headerText = "Characters",
                onBackClick = viewModel::onBackScreen
            )
        }

        items(data) { data ->
            data?.let {
                ItemCard(
                    title = it.attributes.canonicalName,
                    image = it.attributes.image.original,
                    onClick = {},
                    id = it.id
                )
            }
        }
    }
}