@file:OptIn(ExperimentalHorologistApi::class)

package com.example.android.wearable.composestarter.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TitleCard
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import androidx.wear.compose.ui.tooling.preview.WearPreviewFontScales
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.layout.ScalingLazyColumn
import com.google.android.horologist.compose.layout.ScalingLazyColumnDefaults
import com.google.android.horologist.compose.layout.ScreenScaffold
import com.google.android.horologist.compose.layout.rememberResponsiveColumnState
import com.google.android.horologist.compose.material.Chip
import com.google.android.horologist.compose.material.ListHeaderDefaults
import com.google.android.horologist.compose.material.ResponsiveListHeader

@Composable
fun LoadWorkoutScreen(
    onSelectWorkout: () -> Unit,
) {
    val columnState = rememberResponsiveColumnState(
        contentPadding = ScalingLazyColumnDefaults.padding(
            first = ScalingLazyColumnDefaults.ItemType.Text,
            last = ScalingLazyColumnDefaults.ItemType.SingleButton
        )
    )

    ScreenScaffold(scrollState = columnState) {
        ScalingLazyColumn(
            columnState = columnState
        ) {
            item {
                ResponsiveListHeader(contentPadding = ListHeaderDefaults.firstItemPadding()) {
                    Text(text = "Load Workout:")
                }
            }
            item {
                TitleCard(title = { Text("Upper Body") }, onClick = onSelectWorkout) {
                    Text("5 x Bench Press\n" +
                        "3 x Overhead Press\n" +
                        "4 x Lat Pulldown\n" +
                        "3 x Chest Fly")
                }
            }
            item {
                TitleCard(title = { Text("Upper Body") }, onClick = { }) {
                    Text("5 x Bench Press\n" +
                        "3 x Overhead Press\n" +
                        "4 x Lat Pulldown\n" +
                        "3 x Chest Fly")
                }
            }
            item {
                Chip(label = "Load more...", onClick = {})
            }
           item {
                Chip(label = "Exercise List", onClick = {})
            }
            item {
                Chip(
                    label = "Start Empty Workout", onClick = {  },
                    colors = ChipDefaults.chipColors(
                        contentColor = Color.Black,
                        backgroundColor = Color(0xFF00E676)
                    )
                )
            }
        }
    }

}


@WearPreviewDevices
@WearPreviewFontScales
@Composable
fun LoadWorkoutScreenPreview() {
    LoadWorkoutScreen(onSelectWorkout = {})
}
