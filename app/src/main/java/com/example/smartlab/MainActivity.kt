package com.example.smartlab

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.smartlab.layouts.Auntification
import com.example.smartlab.layouts.CodeEmail
import com.example.smartlab.layouts.Main
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
            val navController = rememberNavController()
            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val status = sharedPreferences.getBoolean("key_accept", false)

            SmartLabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var buttonText = ""
                    var headerText = ""
                    var descriptionText = ""
                    var dotsImage = R.drawable.group_1
                    var illustration = R.drawable.photo_2
                    var start = "main"
                    if (status){
                        start = "email" // Должен стоять email но для тестирования стоит core
                    }


                    NavHost(navController, startDestination = start){

                        composable("main"){

                            HorizontalPager(state = pagerState) { page ->
                                if (page == 0) {
                                    buttonText = "Пропустить"
                                    headerText = "Анализы"
                                    descriptionText = "Экспресс сбор и получение проб"
                                    dotsImage = R.drawable.group_1
                                    illustration = R.drawable.photo_1
                                } else if (page == 1) {
                                    buttonText = "Пропустить"
                                    headerText = "Уведомления"
                                    descriptionText = "Вы быстро узнаете о результатах"
                                    dotsImage = R.drawable.group_2
                                    illustration = R.drawable.photo_2
                                } else {
                                    buttonText = "Завершить"
                                    headerText = "Мониторинг"
                                    descriptionText = "Наши врачи всегда наблюдают \n" +
                                            "за вашими показателями здоровья"
                                    dotsImage = R.drawable.group_3
                                    illustration = R.drawable.photo_3
                                }
                                OnBoard(
                                    buttomText = buttonText, headeText = headerText,
                                    descriptionText = descriptionText,
                                    dotsImageVector = ImageVector.vectorResource(dotsImage),
                                    illustration = ImageBitmap.imageResource(illustration),
                                    modifier = Modifier.padding(innerPadding),
                                    onClick = {
                                        val editor = sharedPreferences.edit()
                                        editor.putBoolean("key_accept", true);
                                        editor.apply()

                                    }
                                )
                            }
                        }
                        composable("email"){
                            Auntification(modifier = Modifier.padding(innerPadding), onClick = {
                                navController.navigate("code")
                            })
                        }
                        composable("code"){
                            CodeEmail(modifier = Modifier.padding(innerPadding), onClick = {navController.navigate("email")},navController=navController)
                        }
                        composable("core"){
                            Main()

                        }
                    }
                }
            }
        }
    }
}

