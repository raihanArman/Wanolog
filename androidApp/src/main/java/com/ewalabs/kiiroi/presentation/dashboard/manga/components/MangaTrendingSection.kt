package com.ewalabs.kiiroi.android.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ewalabs.domain.model.MangaListModel
import com.ewalabs.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.ewalabs.kiiroi.composable.components.header.Header
import com.ewalabs.kiiroi.presentation.home.component.ItemCard

/**
 * @author Raihan Arman
 * @date 19/11/22
 */
@Composable
fun MangaTrendingSection(
    modifier: Modifier = Modifier,
    data: List<MangaListModel.MangaModel>
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {

        VerticalSpacer(height = 20.dp)
        Header(
            text = "Trending"
        )
        VerticalSpacer(height = 10.dp)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(data) {
                ItemCard(
                    title = it.attributes.canonicalTitle,
                    image = it.attributes.posterImage.original,
                    modifier = Modifier
                        .width(150.dp),
                    onClick = {},
                    id = it.id,
                    rating = it.attributes.averageRating
                )
            }
        }
    }
}