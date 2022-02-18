package com.example.news.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.news.repository.GlobalRepository
import com.example.news.repository.LocalRepository
import com.example.news.repository.model.News
import com.example.news.repository.room.NewsDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel(application: Application): AndroidViewModel(application) {


    val context = application
    lateinit var localRepository: LocalRepository

    fun initDatabase() {
        val daoRoomNews = NewsDatabase.getInstance(context).getNewsRoomDao()
        localRepository = LocalRepository(daoRoomNews)
    }

    fun loadAllNews(): LiveData<List<News>> {
        return localRepository.liveDataListNews
    }

    suspend fun getTechnologyNews(): LiveData<List<News>> =
        withContext(Dispatchers.IO) {
            GlobalRepository().getTechnologyNews()
        }

    private fun insertNews(news: News) =
        viewModelScope.launch (Dispatchers.IO) {
            localRepository.insertNews(news)
        }

    fun insertAllNews(liveData: LiveData<List<News>>) {
        liveData.value?.forEach {
            insertNews(it)
        }
    }

}