package com.example.smartlab.layouts

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.Actions
import com.example.smartlab.Categories
import com.example.smartlab.Products
import com.example.smartlab.R
import com.example.smartlab.RetrofitHelper
import com.example.smartlab.components.ButtonCategory
import com.example.smartlab.components.CategoryHeaderText
import com.example.smartlab.components.StocksDescriptText

import com.example.smartlab.components.StocksMainText

import com.example.smartlab.components.TextInput
import com.example.smartlab.components.TextInputMain
import com.example.smartlab.ui.theme.BorderColor
import com.example.smartlab.ui.theme.OnboardDescriptionColor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Main(modifier: Modifier = Modifier) {
    var id :Int = 0
    var name :String = ""
    var category_id :Int = 0
    var price : Float = 0.0F
    var text by remember { mutableStateOf("") }
    var showPromotions by remember { mutableStateOf(true) }
    var refreshing by remember { mutableStateOf(false) }
    val productsList = remember { mutableStateListOf<Products>() }
    val categoriesList = remember { mutableStateListOf<Categories>() }
    val actionsList = remember { mutableStateListOf<Actions>() }
    val pagerState = rememberPagerState(pageCount = {
        3
    })
    LaunchedEffect(Unit) {
        RetrofitHelper.productInterface.getProsucts().enqueue(object : Callback<List<Products>> {
            override fun onResponse(call: Call<List<Products>>, response: Response<List<Products>>) {
                response.body()?.let { products ->
                    productsList.clear()
                    productsList.addAll(products)
                }
            }

            override fun onFailure(p0: Call<List<Products>>, p1: Throwable) {
                Log.v("error","error")
            }
        })
        RetrofitHelper.categoryInterface.getCategory().enqueue(object :Callback<List<Categories>>{
            override fun onResponse(p0: Call<List<Categories>>, p1: Response<List<Categories>>) {
                p1.body()?.let { category->
                    categoriesList.clear()
                    categoriesList.addAll(category)
                }
            }

            override fun onFailure(p0: Call<List<Categories>>, p1: Throwable) {
                Log.v("error","error")
            }

        })
        RetrofitHelper.actionsInterface.getActions().enqueue(object :Callback<List<Actions>>{
            override fun onResponse(p0: Call<List<Actions>>, p1: Response<List<Actions>>) {
                p1.body()?.let { actions->
                    actionsList.clear()
                    actionsList.addAll(actions)
                }
            }

            override fun onFailure(p0: Call<List<Actions>>, p1: Throwable) {
                Log.v("error","error")
            }


        })
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectVerticalDragGestures { _, dragAmount ->
                if (dragAmount < 0) { // Swipe up
                    showPromotions = false
                } else if (dragAmount > 0 && !showPromotions) { // Swipe down
                    showPromotions = true
                }
            }
        }) {
        Spacer(modifier = Modifier.height(24.dp))
        TextInputMain(placeholder = "Искать анализы", enabled = true, onTextChange = { if (it.length <= 320) text = it }, text = text, modifier = Modifier.padding(8.dp).fillMaxWidth())
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Акции и новости",
            modifier = modifier.padding(start = 8.dp),
            color = OnboardDescriptionColor,
            fontSize = 17.sp,
            fontWeight = FontWeight.W600,
            lineHeight = 24.sp,
            fontFamily = FontFamily(Font(R.font.nunito_extralight))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState())) {

            actionsList.forEach{ actions->
                Box(modifier = Modifier.padding(8.dp)){
                    Column(modifier = Modifier.fillMaxWidth(0.8f).clip(shape = RoundedCornerShape(12.dp)).background(Color.Blue).padding(16.dp)) {
                        StocksMainText(
                            text = actions.title
                        )
                        StocksDescriptText(
                            text = actions.description
                        )
                        StocksMainText(
                            text = actions.price.toString()
                        )
                    }
                }
            }


                


        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Каталог анализов",
            modifier = modifier.fillMaxWidth().padding(start = 8.dp),
            color = OnboardDescriptionColor,
            fontSize = 17.sp,
            fontWeight = FontWeight.W600,
            lineHeight = 24.sp,
            fontFamily = FontFamily(Font(R.font.nunito_extralight))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState())) {
            categoriesList.forEach {category->
                Box(modifier = Modifier.padding(8.dp)){
                    ButtonCategory(onClick = {}, text = category.name, Enable = true, modifier = Modifier.height(48.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {

            productsList.forEach { product->
                var categor:String = ""
                Box(modifier=Modifier.padding(8.dp).border(width = 1.dp, shape = RoundedCornerShape(12.dp),color = BorderColor).padding(16.dp)){
                    Column {
                        CategoryHeaderText( text=product.name)
                        Row {

                            Column(modifier = Modifier.weight(1f)) {
                                categoriesList.forEach {categories ->
                                    if (product.category_id == categories.id){
                                        categor = categories.name.toString()
                                    }
                                }
                                Text(
                                    text = categor,
                                    modifier = modifier.fillMaxWidth(),
                                    color = OnboardDescriptionColor,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.W600,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.nunito_extralight))
                                )
                                Text(
                                    text = product.price.toString(),
                                    modifier = modifier.fillMaxWidth(),
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.W600,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.nunito_extralight))
                                )
                            }
                            ButtonCategory(onClick = {
                                Log.v("433432","ewqeqwe")

                            }, text = "Добавить", Enable = true, modifier = Modifier.height(48.dp))
                        }
                    }
                }
            }

            }

        }
    }



@Preview
@Composable
private fun MainPreview() {
    Main()
}