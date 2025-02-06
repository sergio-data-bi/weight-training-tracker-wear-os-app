/*
 * Copyright 2024 The Android Open Source Project
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
package com.example.android.wearable.oauth.devicegrant

import com.google.android.horologist.compose.layout.AppScaffold
import com.google.android.horologist.compose.layout.ResponsiveTimeText
import com.google.android.horologist.screenshots.FixedTimeSource
import com.google.android.horologist.screenshots.rng.WearDevice
import com.google.android.horologist.screenshots.rng.WearScreenshotTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.ParameterizedRobolectricTestRunner

@RunWith(ParameterizedRobolectricTestRunner::class)
class AuthenticateScreenTest(override val device: WearDevice) : WearScreenshotTest() {
    override val tolerance = 0.02f

    // code to make sure multiple tests are run
    override fun testName(suffix: String): String =
        "src/test/snapshots/images/" +
            "${this.javaClass.`package`?.name}_${this.javaClass.simpleName}_" +
            "${testInfo.methodName}$suffix.png"

    @Test
    fun authenticateScreenTest() = runTest {
        AppScaffold(
            timeText = { ResponsiveTimeText(timeSource = FixedTimeSource) }
        ) {
            AuthenticateScreenPreview()
        }
    }

    @Test
    fun authenticateFailedScreenTest() = runTest {
        AppScaffold(
            timeText = { ResponsiveTimeText(timeSource = FixedTimeSource) }
        ) {
            AuthenticateScreenFailedPreview()
        }
    }

    companion object {
        @JvmStatic
        @ParameterizedRobolectricTestRunner.Parameters
        fun devices() = WearDevice.entries
    }
}
