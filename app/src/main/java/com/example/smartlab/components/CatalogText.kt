package com.example.smartlab.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.smartlab.R
import java.util.Locale.Category

@Composable
fun CategoryHeaderText(modifier: Modifier = Modifier,text: String) {
    Text(
        text = text,
        modifier = modifier,
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 20.sp,
        fontFamily = FontFamily(Font(R.font.nunito_extralight)))

}