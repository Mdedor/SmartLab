package com.example.smartlab.components

import android.widget.Button
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.ui.theme.AccentColor
import com.example.smartlab.ui.theme.AccentInactiveColor
import com.example.smartlab.ui.theme.EmailColor
import com.example.smartlab.ui.theme.InputBGColor

@Composable
fun ButtonCategory(modifier: Modifier = Modifier, onClick: () -> Unit = {}, Enable:Boolean=true, text:String) {

    Button(
        onClick = {onClick()},
        modifier=modifier,
        enabled = Enable,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AccentColor,
            contentColor = Color.White,
            disabledContentColor = EmailColor,
            disabledContainerColor = InputBGColor
        )
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 24.sp
        )
    }

    }


@Preview
@Composable
private fun ButtonCategoryPreview() {
    ButtonCategory(onClick = {}, text = "Популярные", Enable = false)
}