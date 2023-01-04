package com.ewalabs.kiiroi.composable.components.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ewalabs.kiiroi.composable.components.text.HtmlText

/**
 * @author Raihan Arman
 * @date 09/12/22
 */

@Composable
fun DescriptionPost(
    html: String
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier
        .padding(start = 10.dp, end = 10.dp)) {
        HtmlText(
            html = html,
            maxLines = if (expanded) Int.MAX_VALUE else 5,
            overflow = TextOverflow.Ellipsis,
            onClick = {
                expanded = !expanded
            }
        )
    }
}