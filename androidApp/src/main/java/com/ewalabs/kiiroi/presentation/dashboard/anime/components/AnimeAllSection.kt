package com.ewalabs.kiiroi.android.presentation.home.component

import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.ewalabs.domain.model.AnimeListModel
import com.ewalabs.kiiroi.utils.DASHBOARD_ANIME_CONTENT_TAG
import com.ewalabs.kiiroi.utils.ITEM_CARD_TAG
import com.ewalabs.kiiroi.presentation.home.component.ItemCard

/**
 * @author Raihan Arman
 * @date 17/11/22
 */


@Composable
fun AnimeAllSection(
    modifier: Modifier = Modifier,
    data: List<AnimeListModel.AnimeModel>,
    onClick: (String) -> Unit
) {
    val itemSize: Dp = (LocalConfiguration.current.screenWidthDp.dp / 5)
    FlowRow(
        modifier = modifier
            .testTag(DASHBOARD_ANIME_CONTENT_TAG),
        mainAxisSize = SizeMode.Expand,
        mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
        crossAxisSpacing = 10.dp
    ) {
        data.forEach {
            ItemCard(
                id = it.id,
                title = it.attributes.titles.enJp,
                image = it.attributes.posterImage.original,
                modifier = Modifier.width(itemSize - 30.dp).testTag(ITEM_CARD_TAG),
                onClick = onClick,
                rating = it.attributes.averageRating
            )
        }
    }

}