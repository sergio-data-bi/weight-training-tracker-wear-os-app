@file:OptIn(ExperimentalHorologistApi::class)

package com.example.android.wearable.composestarter.presentation.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TitleCard
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import androidx.wear.compose.ui.tooling.preview.WearPreviewFontScales
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.layout.ScalingLazyColumn
import com.google.android.horologist.compose.layout.ScalingLazyColumnDefaults
import com.google.android.horologist.compose.layout.ScreenScaffold
import com.google.android.horologist.compose.layout.rememberResponsiveColumnState
import com.google.android.horologist.compose.material.Button
import com.google.android.horologist.compose.material.Chip
import com.google.android.horologist.compose.material.CompactChip
import com.google.android.horologist.compose.material.ListHeaderDefaults
import com.google.android.horologist.compose.material.ResponsiveListHeader

@Composable
fun WorkoutOverviewScreen(
    onSelectExercise: () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
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
                    Text(text = "Upper Body")
                }
            }
            item {
                TitleCard(title = { Text("Squat") }, onClick = onSelectExercise) {
                    Text("✅ 40 kg x 12\n⏹️ 60 kg x 8\n⬜ 80 kg x 4")
                }
            }
            item {
                TitleCard(title = { Text("Leg Extension") }, onClick = { }) {
                    Text("⬜ 40 kg x 12\n⬜ 60 kg x 8\n⬜ 80 kg x 4")
                }
            }
            item {
                Chip(label = "➡️ Go Next Set", onClick = { })
            }
            item {
                Chip(label = "Add Exercise", onClick = { })
            }
            item {
                Chip(label = "End Workout", onClick = { })
            }
            item {
                CompactChip(label = "Cancel Workout", onClick = { })
            }
            item {
                Button(
                    imageVector = Icons.Default.Build,
                    contentDescription = "Example Button",
                    onClick = { showDialog = true }
                )
            }
        }
    }
}


@WearPreviewDevices
@WearPreviewFontScales
@Composable
fun WorkoutOverviewScreenPreview() {
    WorkoutOverviewScreen(onSelectExercise = {})
}
