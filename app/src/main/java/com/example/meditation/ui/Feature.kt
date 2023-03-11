package com.example.meditation.ui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.meditation.R
import com.example.meditation.ui.theme.*
import java.io.Serializable

data class Feature(
    val id: String,
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color,
    val caption: String,
    val saved: String,
    val listening: String,
    val subHeading:String
) : Serializable


val features = listOf(
    Feature(
        "2",
        title = "Sleep meditation",
        R.drawable.ic_headphone,
        BlueViolet1,
        BlueViolet2,
        BlueViolet3,
        "Ease the mind into a restful night's sleep with these deep,amblent tones",
        "12,542", "43,453",
        "Best practice meditation"
    ),
    Feature(
        "3",
        title = "Tips for sleeping",
        R.drawable.ic_videocam,
        LightGreen1,
        LightGreen2,
        LightGreen3,
        "Try to go to bed and wake up at the same time every day, even on weekends",
        "11,542", "40,453",
        "Best sleeping tips"
    ),
    Feature(
        "4",
        title = "Night island",
        R.drawable.ic_headphone,
        OrangeYellow1,
        OrangeYellow2,
        OrangeYellow3,
        "Your bedroom should be quiet, dark, and cool. Consider investing in a comfortable mattress and pillows",
        "13,542", "44,453",
        "Best bed preparation"
    ),
    Feature(
        "5",
        title = "Calming sounds",
        R.drawable.ic_headphone,
        Beige1,
        Beige2,
        Beige3,
        "Sounds of nature, such as rain, ocean waves, and birds chirping can be very calming and soothing",
        "19,542", "78,423",
        "Best calming sounds"
    )
)

fun getFeatureById(featureId: String): Feature? {
    return features.find { it.id == featureId }
}