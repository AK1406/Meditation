package com.example.meditation.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import com.example.meditation.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.meditation.Screen
import com.example.meditation.standardQuadFromTo
import com.example.meditation.ui.theme.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(feature: Feature,navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {

        Column {
            NavigationSection(navController)
            HeadingSection(feature)
            SelectedFeature(
                feature = feature
            )
            SelectedFeatureCaption(feature)
            SavedSection(feature)
            RelatedSection(
                features = features,navController
            )
        }
    }
}


@Composable
fun NavigationSection(navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription = "back",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
                .clickable {
                    navController.navigate(Screen.MainScreen.route)
                }
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_star_outline), contentDescription = "star",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun HeadingSection( feature: Feature
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Text(
            feature.title,
            style = MaterialTheme.typography.h1,
            color = TextWhite,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(text = feature.subHeading)
    }
}

@Composable
fun SelectedFeature(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(15.dp)
            .aspectRatio(1.25f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}

@Composable
fun SelectedFeatureCaption(feature: Feature) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Text(
            text = "Sleep music   •   45 min",
            style = MaterialTheme.typography.body1,
            color = TextWhite,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = feature.caption,
            style = MaterialTheme.typography.body1,
            color = TextWhite
        )
    }
}

@Composable
fun SavedSection(
    feature: Feature
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "saved",
                tint = Color.White,
                modifier = Modifier.size(24.dp),
            )
            Text(
                text = "${feature.saved}  Saved",
                color = TextWhite,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_headphone),
                contentDescription = "saved",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "${feature.listening}  Listening",
                color = TextWhite,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Divider(color = BlueViolet1, thickness = 0.7.dp)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun RelatedSection(features: List<Feature>,navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Related",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it],navController)
            }
        }
    }
}
