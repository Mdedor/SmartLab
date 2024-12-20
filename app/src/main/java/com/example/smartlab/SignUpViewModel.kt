package com.example.smartlab

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

public class SignUpViewModell : ViewModel() {
    fun signUp(email: String) {
        viewModelScope.launch {

                val response = RetrofitHelper.emailInterface.equals(object : Callback<Response<Map<String, Any>>>{
                    override fun onResponse(
                        p0: Call<Response<Map<String, Any>>>,
                        p1: Response<Response<Map<String, Any>>>
                    ) {
                        Log.v("1","1")
                    }

                    override fun onFailure(p0: Call<Response<Map<String, Any>>>, p1: Throwable) {
                        Log.v("2","2")
                    }

                })


        }
    }


}