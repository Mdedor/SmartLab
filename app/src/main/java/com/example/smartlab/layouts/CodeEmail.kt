package com.example.smartlab.layouts

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.R
import com.example.smartlab.components.TextInput
import com.example.smartlab.components.TextInputCode

@Composable
fun CodeEmail(modifier: Modifier = Modifier) {
    Column(modifier =Modifier.fillMaxSize()) {
        Image(ImageBitmap.imageResource(R.drawable.back),null, modifier = Modifier.align(Alignment.Start).clickable {  })
        Text(
            text = "Введите код из E-mail",
            fontSize = 17.sp,
            fontWeight = FontWeight(600),
            lineHeight = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(1f)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            repeat(6) {
                Box(modifier = Modifier.weight(1f).padding(5.dp)) {
                    TextInputCode(modifier = Modifier.fillMaxSize())
                }
            }
        }

    }
}

@Preview
@Composable
private fun CodeEmailPreview() {
    CodeEmail()
}