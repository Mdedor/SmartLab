package com.example.smartlab.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
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
fun Auntification(modifier: Modifier = Modifier, ) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(20.dp)) {
        Spacer(Modifier.height(59.dp))
        Row {
            Image(ImageBitmap.imageResource(R.drawable.hello),null, modifier = Modifier.weight(1f))
            Title(text = "Добро пожаловать", modifier = Modifier
                .fillMaxSize(1f)
                .weight(1f))
        }
        Spacer(Modifier.height(23.dp))
        Descript(text = "Войдите, чтобы пользоваться функциями приложения")
        Spacer(Modifier.height(64.dp))
        OnboardDescription(text = "Вход по E-mail")
        Spacer(Modifier.height(4.dp))
        TextInput(placeholder = "example@mail.ru", modifier = Modifier.fillMaxWidth(1f))
        Spacer(Modifier.height(32.dp))
        PrimaryButton(text = "Далее", Enable = false, modifier = Modifier.fillMaxWidth(1f).height(56.dp), )
    }
}

@Preview
@Composable
private fun AuntificationPreview() {
    Auntification()
}