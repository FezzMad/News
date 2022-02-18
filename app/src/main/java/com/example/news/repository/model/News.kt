package com.example.news.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "news_table")
data class News (
    @PrimaryKey
    @SerializedName("url")
    var url : String = "url",

    @ColumnInfo
    @SerializedName("author")
    var author : String = "author",

    @ColumnInfo
    @SerializedName("content")
    var content : String = "content",

    @ColumnInfo
    @SerializedName("date")
    var date : String = "date",

    @ColumnInfo
    @SerializedName("imageUrl")
    var imageUrl : String = "imageUrl",

    @ColumnInfo
    @SerializedName("readMoreUrl")
    var readMoreUrl : String = "readMoreUrl",

    @ColumnInfo
    @SerializedName("time")
    var time : String = "time",

    @ColumnInfo
    @SerializedName("title")
    var title : String = "title",
) : Serializable