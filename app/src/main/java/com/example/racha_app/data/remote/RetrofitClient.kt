package com.example.spring_store.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.spring_store.data.remote.SpringStoreApi

object RetrofitClient {
    private const val BACKEND_URL = "http://192.168.18.7:8080/"

    private val retrofit: Retrofit = Retrofit.Builder().baseUrl(BACKEND_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()

    val api: SpringStoreApi = retrofit.create(SpringStoreApi::class.java)
}