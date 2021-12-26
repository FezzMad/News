package com.example.news.news_list.data

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


// интерфейс и функции получения данных от api (https://github.com/cyberboysumanjay/Inshorts-News-API)
interface InshortsApi {

    // получение информации в виде дата-класса
    @GET("/news")
    fun getNewsData(@Query("category") category: String): Call<Data>

    // получение информации в виде json
    @GET("/news")
    fun getJSON(@Query("category") category: String): Call<ResponseBody>

    /** Возможные категории новостей:
           1. all
           2. national //Indian News only
           3. business
           4. sports
           5. world
           6. politics
           7. technology
           8. startup
           9. entertainment
          10. miscellaneous
          11. hatke
          12. science
          13. automobile */

}

// получение информации в виде дата-класса
fun inshortsNews(): InshortsApi {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://inshortsapi.vercel.app")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(InshortsApi::class.java)
}

// получение информации в виде json
fun inshortsNewsJSON(): InshortsApi {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://inshortsapi.vercel.app")
        .build()

    return retrofit.create(InshortsApi::class.java)
}