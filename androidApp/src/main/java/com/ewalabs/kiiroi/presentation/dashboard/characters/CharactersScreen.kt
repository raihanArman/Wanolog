package com.ewalabs.kiiroi.presentation.dashboard.characters

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.collectAsLazyPagingItems
import com.ewalabs.kiiroi.android.presentation.dashboard.characters.CharacterItem
import com.ewalabs.movieapp_kmm.android.composable.style.MovieAppTheme
import com.ewalabs.kiiroi.utils.items
import org.koin.androidx.compose.getViewModel

/**
 * @author Raihan Arman
 * @date 23/11/22
 */
@Composable
fun CharactersScreen(
    viewModel: CharacterViewModel = getViewModel()
) {
    val paging = viewModel.charaPagination.collectAsLazyPagingItems()

//    LaunchedEffect(key1 = true) {
//        viewModel.getCharacters()
//    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item(span = { GridItemSpan(3) }) {
                Text(
                    text = "Characters",
                    fontSize = 24.sp,
                    color = Color.White,
                    style = MovieAppTheme.typography.bold
                )
            }
            items(paging) { data ->
                data?.let {
                    CharacterItem(data = it)
                }
            }
        }
    }

}