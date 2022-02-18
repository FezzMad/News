package com.example.news.repository

import androidx.lifecycle.LiveData
import com.example.news.repository.room.NewsDao
import com.example.news.repository.model.News

class LocalRepository(private val newsDao: NewsDao){

   val liveDataListNews: LiveData<List<News>>
        get() = newsDao.getLiveDataListNews()


    suspend fun insertNews(news: News) {
        newsDao.insertNews(news)
    }

    suspend fun deleteListNews(listNews: List<News>) {
        return newsDao.deleteListNews(listNews)
    }

}