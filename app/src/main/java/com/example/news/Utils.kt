package com.example.news

import android.content.Context
import android.net.ConnectivityManager
import com.example.news.repository.model.SerializableListNews
import com.example.news.repository.model.News


fun isOnline(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = cm.activeNetworkInfo
    return netInfo != null && netInfo.isConnectedOrConnecting
}

fun pause(msec: Long = 1000) {
    try {
        Thread.sleep(msec)
    } catch (e: Exception) {
    }
}

fun toSerializableListNews(list: List<News>): SerializableListNews {
    return SerializableListNews(list)
}





