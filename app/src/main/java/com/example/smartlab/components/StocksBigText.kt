package com.example.smartlab.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.smartlab.R

@Composable
fun StocksMainText(modifier: Modifier = Modifier,text: String) {
    Text(
        text = text,
        modifier = modifier,
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.W600,
        lineHeight = 28.sp,
        fontFamily = FontFamily(Font(R.font.nunito_extralight))
    )
}

@Preview
@Composable
private fun StocksText() {
    StocksMainText(text = "2323")
}