package com.example.news.news_list.data

import com.google.gson.annotations.SerializedName

// дата-классы для парсинга api (https://github.com/cyberboysumanjay/Inshorts-News-API)
data class NewsData (

    @SerializedName("author") val author : String = "author",
    @SerializedName("content") val content : String = "content",
    @SerializedName("date") val date : String = "date",
    @SerializedName("imageUrl") val imageUrl : String = "imageUrl",
    @SerializedName("readMoreUrl") val readMoreUrl : String = "readMoreUrl",
    @SerializedName("time") val time : String = "time",
    @SerializedName("title") val title : String = "title",
    @SerializedName("url") val url : String = "url"
)

data class Data (

    @SerializedName("category") val category : String,
    @SerializedName("data") val data : List<NewsData>,
    @SerializedName("success") val success : Boolean
)