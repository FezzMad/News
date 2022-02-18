package com.example.news.repository.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.news.repository.model.News

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: News)

    @Query("SELECT * from news_table")
    fun getLiveDataListNews(): LiveData<List<News>>

    @Delete
    suspend fun deleteListNews(listNews: List<News>)
}