package com.ewalabs.kiiroi.composable.components.section

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.ewalabs.domain.model.CategoryModel
import com.ewalabs.kiiroi.composable.components.card.DetailCategoryItem

/**
 * @author Raihan Arman
 * @date 27/11/22
 */

@Composable
fun CategorySection(categories: List<CategoryModel>, onClick: (CategoryModel) -> Unit) {
    Box(
        modifier = Modifier
            .padding(top = 10.dp, end = 25.dp, start = 25.dp, bottom = 20.dp)
    ) {
        FlowRow(
            mainAxisSpacing = 10.dp,
            crossAxisSpacing = 10.dp
        ) {
            categories.forEach {
                DetailCategoryItem(
                    category = it,
                    onClick = onClick
                )
            }
        }
    }
}
