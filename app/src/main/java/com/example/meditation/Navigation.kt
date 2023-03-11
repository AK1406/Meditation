package com.example.meditation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.meditation.ui.DetailScreen
import com.example.meditation.ui.Feature
import com.example.meditation.ui.HomeScreen
import com.example.meditation.ui.getFeatureById


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(
            route = "${Screen.DetailScreen.route}/{featureId}",
            arguments = listOf(
                navArgument("featureId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val featureId = backStackEntry.arguments?.getString("featureId")
            val feature = featureId?.let { getFeatureById(it) }
            if (feature != null) {
                DetailScreen(feature = feature, navController = navController)
            }
        }
    }
}

