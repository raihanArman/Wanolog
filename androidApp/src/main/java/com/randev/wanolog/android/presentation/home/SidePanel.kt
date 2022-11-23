package com.randev.wanolog.android.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.randev.domain.model.CategoryListModel
import com.randev.movieapp_kmm.android.composable.components.space.VerticalSpacer
import com.randev.movieapp_kmm.android.composable.style.MovieAppTheme
import com.randev.wanolog.android.composable.components.header.Header

/**
 * @author Raihan Arman
 * @date 21/11/22
 */

@Composable
fun SidePanel(
    categories: List<CategoryListModel.CategoryModel>
) {

    LazyColumn(
        modifier = Modifier
            .background(Color.Black)
    ) {
        item {
            Column(
                modifier = Modifier.padding(
                    top = 10.dp,
                    start = 16.dp,
                    end = 10.dp,
                ),
            ) {
                Text(
                    text = "Category",
                    color = Color.White,
                    style = MovieAppTheme.typography.bold,
                    fontSize = 16.sp
                )
                VerticalSpacer(height = 20.dp)
            }
        }
        items(categories){ category ->
            Box(
                modifier = Modifier.padding(
                    start = 10.dp,
                    end = 10.dp,
                ),
            ) {
                ItemCategorySidePanel(category = category)
            }
        }
    }
}

@Composable
fun ItemCategorySidePanel(category: CategoryListModel.CategoryModel) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val color = if (isPressed) Color.White.copy(0.2f) else Color.Black

    TextButton(
        interactionSource = interactionSource,
        colors= ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {

        }
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = category.title,
            color = Color.White,
            style = MovieAppTheme.typography.medium,
            fontSize = 14.sp,
            textAlign = TextAlign.Start
        )
    }
}