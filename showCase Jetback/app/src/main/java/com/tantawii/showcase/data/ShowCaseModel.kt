package com.tantawii.showcase.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutCoordinates

data class ShowCaseModel(
    val index: Int,
    val coordinates: LayoutCoordinates,
    val title: String,
    val subTitle: String,
    val colorName: Color = Color.White,
    val colorSubName: Color = Color.White
)
