package com.randev.kiiroi.android.composable.components.image

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp

/**
 * @author Raihan Arman
 * @date 27/11/22
 */

@Composable
fun ImageDrawLayout(
    modifier: Modifier = Modifier,
    itemCount: Int,
    divider: Dp,
    content: @Composable () -> Unit
) {

    val spacePx = LocalDensity.current.run { (divider).roundToPx() }

    val measurePolicy = remember(itemCount, spacePx) {
        MeasurePolicy { measurables, constraints ->

            val newConstraints = when (itemCount) {
                1 -> constraints
                2 -> Constraints.fixed(
                    width = constraints.maxWidth / 2 - spacePx / 2,
                    height = constraints.maxHeight
                )
                else -> Constraints.fixed(
                    width = constraints.maxWidth / 2 - spacePx / 2,
                    height = constraints.maxHeight / 2 - spacePx / 2
                )
            }

            val gridMeasurables = if (itemCount < 5) {
                measurables
            } else {
                measurables.take(3) + measurables.first { it.layoutId == "Text" }
            }

            val placeables: List<Placeable> = if (measurables.size != 3) {
                gridMeasurables.map { measurable: Measurable ->
                    measurable.measure(constraints = newConstraints)
                }
            } else {
                gridMeasurables
                    .take(2)
                    .map { measurable: Measurable ->
                        measurable.measure(constraints = newConstraints)
                    } +
                        gridMeasurables
                            .last()
                            .measure(
                                constraints = Constraints.fixed(
                                    constraints.maxWidth,
                                    constraints.maxHeight / 2 - spacePx
                                )
                            )
            }

            layout(constraints.maxWidth, constraints.maxHeight) {
                when (itemCount) {
                    1 -> {
                        placeables.forEach { placeable: Placeable ->
                            placeable.placeRelative(0, 0)
                        }
                    }
                    2 -> {
                        var xPos = 0
                        placeables.forEach { placeable: Placeable ->
                            placeable.placeRelative(xPos, 0)
                            xPos += placeable.width + spacePx
                        }
                    }
                    else -> {
                        var xPos = 0
                        var yPos = 0

                        placeables.forEachIndexed { index: Int, placeable: Placeable ->
                            placeable.placeRelative(xPos, yPos)

                            if (index % 2 == 0) {
                                xPos += placeable.width + spacePx
                            } else {
                                xPos = 0
                            }

                            if (index % 2 == 1) {
                                yPos += placeable.height + spacePx
                            }
                        }
                    }
                }
            }
        }
    }

    Layout(
        modifier = modifier,
        content = content,
        measurePolicy = measurePolicy
    )
}