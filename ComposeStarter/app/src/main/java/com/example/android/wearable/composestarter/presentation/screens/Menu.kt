@file:OptIn(ExperimentalHorologistApi::class)

package com.example.android.wearable.composestarter.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import androidx.wear.compose.ui.tooling.preview.WearPreviewFontScales
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.layout.ScalingLazyColumn
import com.google.android.horologist.compose.layout.ScalingLazyColumnDefaults
import com.google.android.horologist.compose.layout.ScreenScaffold
import com.google.android.horologist.compose.layout.rememberResponsiveColumnState
import com.google.android.horologist.compose.material.Chip
import com.google.android.horologist.compose.material.CompactChip

@Composable
fun MenuScreen(
    onStartEmptyWorkout: () -> Unit,
    onLoadWorkout: () -> Unit
) {
    var selectedUnit by rememberSaveable { mutableStateOf("Metric") }

    val columnState = rememberResponsiveColumnState(
        contentPadding = ScalingLazyColumnDefaults.padding(
            first = ScalingLazyColumnDefaults.ItemType.Text,
            last = ScalingLazyColumnDefaults.ItemType.Chip
        )
    )
    ScreenScaffold(scrollState = columnState) {
        ScalingLazyColumn(columnState = columnState) {
            item {
                Chip(
                    label = "Start Empty Workout", onClick = { },
                    colors = ChipDefaults.chipColors(
                        contentColor = Color.Black,
                        backgroundColor = Color(0xFF00E676)
                    )
                )
            }
            item {
                Chip(label = "Load Workout", onClick = onLoadWorkout)
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CustomCompactChip(
                        label = "Metric",
                        isSelected = (selectedUnit == "Metric"),
                        onClick = { selectedUnit = "Metric" }
                    )

                    CustomCompactChip(
                        label = "Imperial",
                        isSelected = (selectedUnit == "Imperial"),
                        onClick = { selectedUnit = "Imperial" }
                    )
                }
            }

        }
    }
}

@Composable
fun CustomCompactChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    if (isSelected) {
        CompactChip(
            label = label,
            onClick = onClick,
            border = ChipDefaults.chipBorder(
                BorderStroke(
                    2.dp,
                    Color.White
                )
            )
        )
    } else {
        CompactChip(
            label = label,
            onClick = onClick,
            colors = ChipDefaults.chipColors(
                MaterialTheme.colors.primaryVariant,
                contentColor = Color(0xFF888888)
            )
        )
    }
}

@WearPreviewDevices
@WearPreviewFontScales
@Composable
fun MenuScreenPreview() {
    MenuScreen(
        onStartEmptyWorkout = { },
        onLoadWorkout = { }
    )
}
