package com.randev.wanolog.android.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.randev.domain.model.CategoryListModel
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.wanolog.android.composable.components.header.Header

/**
 * @author Raihan Arman
 * @date 17/11/22
 */

@Composable
fun CategorySection(
    modifier: Modifier = Modifier,
    data: List<CategoryListModel.CategoryModel>
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {

        Header(
            text = "Category"
        )
        VerticalSpacer(height = 10.dp)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(data) {
                CategoryItem(title = it.title)
            }
        }
    }
}