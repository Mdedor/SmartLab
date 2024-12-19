package com.example.smartlab.layouts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.R
import com.example.smartlab.components.ButtonCategory
import com.example.smartlab.components.CategoryHeaderText
import com.example.smartlab.components.StocksDescriptText

import com.example.smartlab.components.StocksMainText

import com.example.smartlab.components.TextInput
import com.example.smartlab.components.TextInputMain
import com.example.smartlab.ui.theme.BorderColor
import com.example.smartlab.ui.theme.OnboardDescriptionColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Main(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    val pagerState = rememberPagerState(pageCount = {
        3
    })
    Column {

        TextInputMain(placeholder = "Искать анализы", enabled = true, onTextChange = { if (it.length <= 320) text = it }, text = text)
        Text(
            text = "Акции и новости",
            modifier = modifier,
            color = OnboardDescriptionColor,
            fontSize = 17.sp,
            fontWeight = FontWeight.W600,
            lineHeight = 24.sp,
            fontFamily = FontFamily(Font(R.font.nunito_extralight))
        )
            Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState())) {
                repeat(10){
                    Box(modifier = Modifier.padding(8.dp)){
                        Column(modifier = Modifier.fillMaxWidth(0.8f).clip(shape = RoundedCornerShape(12.dp)).background(Color.Blue).padding(16.dp)) {
                            StocksMainText(
                                text = "Чек-ап для мужчин"
                            )
                            StocksDescriptText(
                                text = "9 исследований"
                            )
                            StocksMainText(
                                text = "8000"
                            )
                        }
                    }

                }

            }

        Text(
            text = "Каталог анализов",
            modifier = modifier.fillMaxWidth(),
            color = OnboardDescriptionColor,
            fontSize = 17.sp,
            fontWeight = FontWeight.W600,
            lineHeight = 24.sp,
            fontFamily = FontFamily(Font(R.font.nunito_extralight))
        )
        Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState())) {
            Box(modifier = Modifier.padding(8.dp)){
                ButtonCategory(onClick = {}, text = "Популярные", Enable = true, modifier = Modifier.height(48.dp))
            }
            repeat(10) {
                Box(modifier = Modifier.padding(8.dp)){
                ButtonCategory(onClick = {}, text = "Популярные", Enable = false, modifier = Modifier.height(48.dp))
                }

            }
        }
        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            Box(modifier=Modifier.border(width = 1.dp, shape = RoundedCornerShape(12.dp),color = BorderColor)){
                CategoryHeaderText( text="ПЦР-тест на определение РНК коронавируса стандартный")
            }
        }
    }

}

@Preview
@Composable
private fun MainPreview() {
    Main()
}