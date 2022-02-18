package com.example.news.repository.api

import com.example.news.repository.model.ResponseAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InshortsNews {
    @GET("/news")
    fun callDataAPI(@Query("category") category: String): Call<ResponseAPI>
}
