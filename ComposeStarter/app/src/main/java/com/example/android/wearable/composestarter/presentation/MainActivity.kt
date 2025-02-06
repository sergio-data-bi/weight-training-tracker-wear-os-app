package com.example.android.wearable.composestarter.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.android.wearable.composestarter.presentation.screens.ActiveSetScreen
import com.example.android.wearable.composestarter.presentation.screens.LoadWorkoutScreen
import com.example.android.wearable.composestarter.presentation.screens.MenuScreen
import com.example.android.wearable.composestarter.presentation.screens.WorkoutOverviewScreen
import com.example.android.wearable.composestarter.presentation.theme.WearAppTheme
import com.google.android.horologist.compose.layout.AppScaffold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    val navController = rememberSwipeDismissableNavController()

    WearAppTheme {
        AppScaffold {
            SwipeDismissableNavHost(navController = navController, startDestination = "menu") {
                composable("menu") {
                    MenuScreen(
                        onStartEmptyWorkout = { navController.navigate("exerciseOverview") },
                        onLoadWorkout = { navController.navigate("loadWorkout") }
                    )
                }
                composable("loadWorkout") {
                    LoadWorkoutScreen(onSelectWorkout = { navController.navigate("exerciseOverview") })
                }
                composable("exerciseOverview") {
                    WorkoutOverviewScreen(onSelectExercise = { navController.navigate("exercise") })
                }
                composable(route = "exercise") {
                    ActiveSetScreen()
                }
            }
        }
    }
}


