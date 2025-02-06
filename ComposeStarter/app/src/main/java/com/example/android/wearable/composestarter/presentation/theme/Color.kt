/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.wearable.composestarter.presentation.theme

import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.Colors

val Charcoal200 = Color(0xFF2C2C2C)
val Charcoal500 = Color(0xFF1C1C1C)
val Charcoal700 = Color(0xFF121212)
val Slate200 = Color(0xFF37474F)
val Crimson400 = Color(0xFFB00020)

internal val wearColorPalette: Colors = Colors(
    primary = Charcoal200,
    primaryVariant = Charcoal700,
    secondary = Slate200,
    secondaryVariant = Slate200,
    error = Crimson400,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onError = Color.White
)

