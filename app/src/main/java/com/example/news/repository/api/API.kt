package com.example.news.repository.api

import com.example.news.baseUrl
import com.example.news.repository.model.News
import com.example.news.repository.model.ResponseAPI
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getInshortsNews(): InshortsNews {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(InshortsNews::class.java)
}

suspend fun getListNews(responseAPI: ResponseAPI):List<News> = withContext(Dispatchers.IO) {
    return@withContext responseAPI.listNews
}
