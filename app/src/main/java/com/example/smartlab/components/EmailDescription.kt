package com.example.smartlab.components

import android.media.audiofx.AudioEffect.Descriptor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable
fun Descript(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        fontSize = 15.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(400)
    )
}