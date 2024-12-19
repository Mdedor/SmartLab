package com.example.smartlab.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.controls.ui.theme.Components.OnboardDescription
import com.example.smartlab.R
import com.example.smartlab.components.Descript
import com.example.smartlab.components.PrimaryButton
import com.example.smartlab.components.TextInput
import com.example.smartlab.components.Title

@Composable
fun Auntification(modifier: Modifier = Modifier ) {
    var text by remember { mutableStateOf("") }
    Column(modifier = modifier
        .fillMaxSize()
        .padding(20.dp)) {
        Spacer(Modifier.height(59.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), // Задайте высоту Row
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically // Центрирование по вертикали
        ) {
            Image(ImageBitmap.imageResource(R.drawable.hello),null, modifier = Modifier.size(24.dp))
            Title(text = "Добро пожаловать!", modifier = Modifier.align(Alignment.CenterVertically))
        }
        Spacer(Modifier.height(23.dp))
        Descript(text = "Войдите, чтобы пользоваться функциями приложения")
        Spacer(Modifier.height(64.dp))
        OnboardDescription(text = "Вход по E-mail")
        Spacer(Modifier.height(4.dp))

        TextInput(placeholder = "example@mail.ru", modifier = Modifier.fillMaxWidth(1f).height(72.dp), onTextChange = { if (it.length <= 320) text = it }, text = text)
        Spacer(Modifier.height(32.dp))
        PrimaryButton(text = "Далее", Enable = text.isNotEmpty(), modifier = Modifier.fillMaxWidth(1f).height(56.dp), onClick = {})
    }
}

@Preview
@Composable
private fun AuntificationPreview() {
    Auntification()
}