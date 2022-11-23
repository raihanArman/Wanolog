package com.randev.wanolog.android.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.randev.domain.model.AnimeListModel
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.wanolog.android.composable.components.header.Header

/**
 * @author Raihan Arman
 * @date 17/11/22
 */


@Composable
fun AnimeAllSection(
    modifier: Modifier = Modifier,
    data: List<AnimeListModel.AnimeModel>
) {

    val itemSize: Dp = (LocalConfiguration.current.screenWidthDp.dp / 2)
    FlowRow(
        mainAxisSize = SizeMode.Expand,
        mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
        crossAxisSpacing = 10.dp
    ) {
        data.forEach {
            ItemCard(title = it.attributes.titles.enJp, image = it.attributes.posterImage.original, modifier = Modifier.width(itemSize - 30.dp))
        }
    }

}