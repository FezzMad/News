package com.example.news.repository.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.news.repository.model.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsLiveData {
    companion object {
        suspend fun getTechnology(): LiveData<List<News>> = withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<News>>()
            liveData.postValue(NewsList.getTechnology())
            return@withContext  liveData
        }

        suspend fun getAll(): LiveData<List<News>> = withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<News>>()
            liveData.postValue(NewsList.getAll())
            return@withContext  liveData
        }

        suspend fun getBusiness(): LiveData<List<News>> = withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<News>>()
            liveData.postValue(NewsList.getBusiness())
            return@withContext  liveData
        }

        suspend fun getWorld(): LiveData<List<News>> = withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<News>>()
            liveData.postValue(NewsList.getWorld())
            return@withContext  liveData
        }

        suspend fun getSports(): LiveData<List<News>> = withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<News>>()
            liveData.postValue(NewsList.getSports())
            return@withContext  liveData
        }

        suspend fun getPolitics(): LiveData<List<News>> = withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<News>>()
            liveData.postValue(NewsList.getPolitics())
            return@withContext  liveData
        }

        suspend fun getStartup(): LiveData<List<News>> = withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<News>>()
            liveData.postValue(NewsList.getStartup())
            return@withContext  liveData
        }

        suspend fun getEntertainment(): LiveData<List<News>> = withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<News>>()
            liveData.postValue(NewsList.getEntertainment())
            return@withContext  liveData
        }

        suspend fun getMiscellaneous(): LiveData<List<News>> = withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<News>>()
            liveData.postValue(NewsList.getMiscellaneous())
            return@withContext  liveData
        }

        suspend fun getHatke(): LiveData<List<News>> = withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<News>>()
            liveData.postValue(NewsList.getHatke())
            return@withContext  liveData
        }

        suspend fun getScience(): LiveData<List<News>> = withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<News>>()
            liveData.postValue(NewsList.getScience())
            return@withContext  liveData
        }

        suspend fun getAutomobile(): LiveData<List<News>> = withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<News>>()
            liveData.postValue(NewsList.getAutomobile())
            return@withContext  liveData
        }

        suspend fun getNational(): LiveData<List<News>> = withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<News>>()
            liveData.postValue(NewsList.getNational())
            return@withContext  liveData
        }
    }
}