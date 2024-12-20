package com.example.smartlab

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


interface ProductInterface {
    @Headers("apikey:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InpxaHpxaWpianZwdmR3c2didmx4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzQ0MTY2MDcsImV4cCI6MjA0OTk5MjYwN30.DH8ssnBu7-2YmfAykIwSO3vf7Hx4rGmE20NS6WxTvLA","Authorization:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InpxaHpxaWpianZwdmR3c2didmx4Iiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTczNDQxNjYwNywiZXhwIjoyMDQ5OTkyNjA3fQ.kMe-HzsRd6JfG0TnncjyoWcwTOADyDUhw4tgjQTb12E")
    @GET("rest/v1/products?select ")
    fun getProsucts(): Call<List<Products>>
}