package com.example.smartlab.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.trace
import com.example.smartlab.ui.theme.AccentColor
import com.example.smartlab.ui.theme.InputBGColor
import com.example.smartlab.ui.theme.InputFocusedBorderColor
import com.example.smartlab.ui.theme.InputStrokeColor

@Composable
fun TextInput(modifier: Modifier = Modifier, placeholder: String, enabled: Boolean = true,onTextChange: (String) -> Unit,text:String) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        modifier = modifier,
        enabled = enabled,
        placeholder = {
            Text(
                text = placeholder,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
            )
        },
        textStyle = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = InputBGColor,
            unfocusedContainerColor = InputBGColor,
            focusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
            unfocusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
            focusedBorderColor = InputFocusedBorderColor,
            unfocusedBorderColor = InputStrokeColor,
            cursorColor = AccentColor
        ),
        shape = RoundedCornerShape(10.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Preview
@Composable
private fun TextInputPreview() {
    var text by remember { mutableStateOf("") }
    TextInput(placeholder = "Поле для ввода с подсказкой", enabled = true, onTextChange = { if (it.length <= 320) text = it }, text = text)
}