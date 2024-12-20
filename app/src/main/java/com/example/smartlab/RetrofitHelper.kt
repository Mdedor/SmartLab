package com.example.smartlab

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.39",3128))
val httpClient = OkHttpClient.Builder().proxy(proxy).build()
object RetrofitHelper {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://zqhzqijbjvpvdwsgbvlx.supabase.co/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
        val productInterface = retrofit.create(ProductInterface::class.java)
}