package com.example.meditation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.meditation.ui.DetailScreen
import com.example.meditation.ui.HomeScreen
import com.example.meditation.ui.theme.MeditationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationTheme {
                Navigation()
                //DetailScreen()
            }
        }
    }
}



