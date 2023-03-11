package com.example.meditation

import com.example.meditation.ui.Feature

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")


    object DetailScreenWithFeature : Screen("detail_screen/{featureId}") {
        fun createRoute(featureId: String): String {
            return "detail_screen/$featureId"
        }
    }

    // Function to navigate to DetailScreenWithFeature with a given feature
    fun createDetailScreenWithFeatureRoute(feature: Feature): String {
        return DetailScreenWithFeature.createRoute(feature.id.toString())
    }
}
