package com.ewalabs.kiiroi.composable.components.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ewalabs.domain.model.CategoryModel
import com.ewalabs.movieapp_kmm.android.composable.style.Colors
import com.ewalabs.movieapp_kmm.android.composable.style.MovieAppTheme

/**
 * @author Raihan Arman
 * @date 27/11/22
 */
@Composable
fun DetailCategoryItem(
    modifier: Modifier = Modifier,
    category: CategoryModel,
    onClick: (CategoryModel) -> Unit
) {
    Surface(
        modifier = modifier
            .clickable {
                onClick(category)
            },
        shape = RoundedCornerShape(5.dp),
        color = Colors.raisinBlack
    ) {
        Text(
            text = category.title,
            color = Color.Gray,
            style = MovieAppTheme.typography.medium,
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 8.dp, bottom = 8.dp)
        )
    }
}