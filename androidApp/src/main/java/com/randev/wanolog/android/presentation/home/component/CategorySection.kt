package com.randev.wanolog.android.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    data: List<CategoryListModel.CategoryModel>,
    openDrawer: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {

        Header(
            text = "Category"
        ) {
            IconButton(onClick = openDrawer) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.White
                )
            }
        }
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