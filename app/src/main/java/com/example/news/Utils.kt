package com.example.news

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.preference.PreferenceManager
import com.example.news.news_list.data.NewsData

import java.io.*


// сохранение значения типа String
internal fun saveStrValue(key: String, value: String, context: Context) {
    val myEditor: SharedPreferences.Editor =
        PreferenceManager.getDefaultSharedPreferences(context).edit()
    myEditor.putString(key, value)
    myEditor.apply()
}

// сохранение значения типа List<NewsData> (информация с api)
internal fun saveNewsDataValue(newsData: List<NewsData>, position: Int, context: Context) {
    val date = newsData[position].date
    saveStrValue("date", date, context)

    val time = newsData[position].time
    saveStrValue("time", time, context)

    val author = newsData[position].author
    saveStrValue("author", author, context)

    val content = newsData[position].content
    saveStrValue("content", content, context)

    val readMoreUrl = newsData[position].readMoreUrl
    saveStrValue("readMoreUrl", readMoreUrl, context)

    val imageUrl = newsData[position].imageUrl
    saveStrValue("imageUrl", imageUrl, context)
}

// загрузка значения типа List<NewsData> (информация с api)
internal fun loadNewsDataValue(context: Context): NewsData {
    val date = loadStrValue("date", context)

    val time = loadStrValue("time", context)

    val author = loadStrValue("author", context)

    val content = loadStrValue("content", context)

    val readMoreUrl = loadStrValue("readMoreUrl", context)

    val imageUrl = loadStrValue("imageUrl", context)

    return if (date != null && time != null && author != null && content != null && readMoreUrl != null && imageUrl != null)
        NewsData(
            date = date,
            time = time,
            author = author,
            content = content,
            readMoreUrl = readMoreUrl,
            imageUrl = imageUrl
        )
    else NewsData()
}

// загрузка значения типа String
internal fun loadStrValue(key: String, context: Context): String? {
    val result =
        PreferenceManager.getDefaultSharedPreferences(context).getString(key, "null_result")
    return if (result != null && result != "") result
    else null
}

// проврека наличия интернет-соединения
internal fun isOnline(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = cm.activeNetworkInfo
    return netInfo != null && netInfo.isConnectedOrConnecting
}

// открытие файла из внутренней памяти
internal fun openFile(fileName: String, context: Context): String {
    var textFromFile = ""

    try {
        textFromFile =
            File(context.filesDir, fileName)
                .bufferedReader()
                .use { it.readText(); }

    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    }

    return textFromFile
}

// сохранение файла во внутреннюю память
internal fun saveFile(text: String, fileName: String, context: Context) {
    try {
        context.openFileOutput(fileName, Context.MODE_PRIVATE).use {
            it.write(text.toByteArray())
        }
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}





