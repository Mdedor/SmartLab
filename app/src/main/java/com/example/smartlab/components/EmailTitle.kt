package com.example.smartlab.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable
fun Title(modifier: Modifier = Modifier,text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight(700),
        lineHeight = 29.sp,
        modifier = Modifier.fillMaxWidth()
    )
}