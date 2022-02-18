package com.example.news.repository.model

import com.example.news.plugNewsList
import com.google.gson.annotations.SerializedName

data class ResponseAPI (
    @SerializedName("category") val category : String = "technology",
    @SerializedName("data") val listNews : List<News> = plugNewsList,
    @SerializedName("success") val success : Boolean = false
)