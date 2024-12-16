package com.example.smartlab

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.smartlab.layouts.OnBoard
import com.example.smartlab.ui.theme.SmartLabTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            val pagerState = rememberPagerState(pageCount = {
                3
            })
            SmartLabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HorizontalPager(state = pagerState) {page->
                        if (page == 0) {

                            OnBoard(
                                buttomText = "Пропустить", headeText = "Анализы",
                                descriptionText = "Экспресс сбор и получение проб",
                                dotsImageVector = ImageVector.vectorResource(R.drawable.group_1),
                                illustration = ImageBitmap.imageResource(R.drawable.photo_1),
                                modifier = Modifier.padding(innerPadding)
                            )
                        }else if (page==1) {

                            OnBoard(
                                buttomText = "Пропустить", headeText = "Уведомления",
                                descriptionText = "Вы быстро узнаете о результатах",
                                dotsImageVector = ImageVector.vectorResource(R.drawable.group_2),
                                illustration = ImageBitmap.imageResource(R.drawable.photo_2),
                                modifier = Modifier.padding(innerPadding))
                        }else{

                            OnBoard(
                                buttomText = "Завершить", headeText = "Мониторинг",
                                descriptionText = "Наши врачи всегда наблюдают \n" +
                                        "за вашими показателями здоровья",
                                dotsImageVector = ImageVector.vectorResource(R.drawable.group_3),
                                illustration = ImageBitmap.imageResource(R.drawable.photo_3),
                                modifier = Modifier.padding(innerPadding))
                        }



                    }

                }
            }
        }
    }
}

