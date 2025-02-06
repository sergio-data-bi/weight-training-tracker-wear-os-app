@file:OptIn(ExperimentalHorologistApi::class)

package com.example.android.wearable.composestarter.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.ChipColors
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Text
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import androidx.wear.compose.ui.tooling.preview.WearPreviewFontScales
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.layout.ScalingLazyColumn
import com.google.android.horologist.compose.layout.ScalingLazyColumnDefaults
import com.google.android.horologist.compose.layout.ScreenScaffold
import com.google.android.horologist.compose.layout.rememberResponsiveColumnState
import com.google.android.horologist.compose.material.Button
import com.google.android.horologist.compose.material.CompactChip
import com.google.android.horologist.compose.material.ListHeaderDefaults
import com.google.android.horologist.compose.material.ResponsiveListHeader

@Composable
fun ActiveSetScreen() {
    val columnState = rememberResponsiveColumnState(
        verticalArrangement = Arrangement.spacedBy(0.dp),
        contentPadding = ScalingLazyColumnDefaults.padding(
            first = ScalingLazyColumnDefaults.ItemType.Text,
            last = ScalingLazyColumnDefaults.ItemType.Text
        )
    )

    ScreenScaffold(scrollState = columnState) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                Spacer(modifier = Modifier.height(30.dp))

                Text(text = "••• Bench Press",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp)
                Spacer(modifier = Modifier.height(2.dp))

                Text(text ="68 ❤️",
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp)
                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    ActiveSetInputBox("280", "kg")
                    ActiveSetInputBox("13", "reps")
                }
                Spacer(modifier = Modifier.height(4.dp))

                Text(text ="Prev: 260 kg x 11 reps",
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp)
                Spacer(modifier = Modifier.height(6.dp))

                Button(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Done",
                    modifier = Modifier.size(size = 34.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF00E676),
                        contentColor = Color.Black
                    ),
                    onClick = {  }
                )
            }

        }
    }

@Composable
private fun ActiveSetInputBox(
    textContent: String = "",
    textDescription: String = "",
) {
    val textContentSize = 22.sp
    val textFontSize = 12.sp
    val boxSize = 60.dp
    val borderWidth = 3.dp
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(boxSize)
            .border(borderWidth, Color.DarkGray)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = textContent,
                fontSize = textContentSize
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = textDescription,
                fontSize = textFontSize
            )
        }
    }
}


@WearPreviewDevices
@WearPreviewFontScales
@Composable
fun ActiveSetScreenPreview() {
    ActiveSetScreen()
}
