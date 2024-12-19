package com.example.smartlab.layouts

import android.app.Activity.MODE_PRIVATE
import android.media.audiofx.AudioEffect.Descriptor
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.controls.ui.theme.Components.OnboardDescription
import com.example.controls.ui.theme.Components.OnboardHeader
import com.example.controls.ui.theme.Components.TextButton
import com.example.smartlab.R

import org.w3c.dom.Text

@Composable
fun OnBoard(modifier: Modifier = Modifier,buttomText: String,headeText: String,descriptionText: String, dotsImageVector: ImageVector,illustration: ImageBitmap, onClick: () -> Unit = {}) {
    Column(modifier = modifier.fillMaxSize().padding(20.dp)) {

        Row {
            TextButton(text = buttomText, modifier = Modifier.weight(1f), onClick = {onClick() })
            Image(ImageVector.vectorResource(R.drawable.shape),null, modifier = Modifier.weight(1f))
        }
        Spacer(Modifier.height(29.dp))
        OnboardHeader(text = headeText, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.height(29.dp))
        OnboardDescription(text = descriptionText, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.height(60.dp))
        Image(dotsImageVector,null, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.weight(1f))
        Image(illustration,null, modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxSize(0.8f))
    }
}

@Preview
@Composable
private fun OnBoardPrewiew() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "email"){
        composable("email"){
            Auntification()
        }
    }
    OnBoard(
        buttomText = "Пропустить", headeText = "Анализы",
        descriptionText = "Экспресс сбор и получение проб",
        dotsImageVector = ImageVector.vectorResource(R.drawable.group_1),
        illustration = ImageBitmap.imageResource(R.drawable.photo_1))
}