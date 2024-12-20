package com.example.smartlab.layouts

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartlab.R
import com.example.smartlab.components.TextInput
import com.example.smartlab.components.TextInputCode
import com.example.smartlab.ui.theme.OnboardDescriptionColor
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun CodeEmail(modifier: Modifier = Modifier, onClick: () -> Unit = {},navController: NavController) {

    var ticks by remember { mutableStateOf(60) }

    LaunchedEffect(Unit) {
        while(true) {
            delay(1.seconds)
            ticks--
            if (ticks == 0)
                ticks = 60
        }
    }
    Column(modifier =Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(24.dp))
        Image(ImageBitmap.imageResource(R.drawable.back),null, modifier = Modifier
            .align(Alignment.Start)
            .clickable { onClick() }
            .size(40.dp))
        Spacer(modifier = Modifier.height(132.dp))
        Text(
            text = "Введите код из E-mail",
            fontSize = 17.sp,
            fontWeight = FontWeight(600),
            lineHeight = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(1f)
        )
        Spacer(modifier = Modifier.height(20.dp))
        val textFields = rememberSaveable { List(6) { mutableStateOf("") } }


            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                textFields.forEachIndexed { index, textState ->
                Box(modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)) {

                    TextField(
                        value = textState.value,
                        onValueChange = { newValue ->
                            if (newValue.length <= 1) {
                                textState.value = newValue
                                // Если поле заполнено, переходим к следующему

                            }
                            // Если последнее поле заполнено, переходим на следующий экран
                            if (index == textFields.size - 1 && newValue.length == 1) {
                                navController.navigate("core")
                            }
                        },

                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                        shape = RoundedCornerShape(10.dp),
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            lineHeight = 28.sp,
                            textAlign = TextAlign.Center
                        ),
                    )
                }

            }

        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Отправить код повторно можно будет через ${ticks} секунд",
            fontSize = 15.sp,
            fontWeight = FontWeight(400),
            lineHeight = 20.sp,
            color = OnboardDescriptionColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(1f)
        )

    }
}

