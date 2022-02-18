package com.example.news.repository.api

import androidx.lifecycle.LiveData
import com.example.news.repository.model.News

class NewsCategory {
    companion object {
        suspend fun getAutomobileNews(): LiveData<List<News>> =
            NewsLiveData.getAutomobile()

        suspend fun getScienceNews(): LiveData<List<News>> =
            NewsLiveData.getScience()

        suspend fun getHatkeNewsNews(): LiveData<List<News>> =
            NewsLiveData.getHatke()

        suspend fun getEntertainmentNewsNews(): LiveData<List<News>> =
            NewsLiveData.getEntertainment()

        suspend fun getStartupNews(): LiveData<List<News>> =
            NewsLiveData.getStartup()

        suspend fun getPoliticsNews(): LiveData<List<News>> =
            NewsLiveData.getPolitics()

        suspend fun getSportsNews(): LiveData<List<News>> =
            NewsLiveData.getSports()

        suspend fun getWorldNews(): LiveData<List<News>> =
            NewsLiveData.getWorld()

        suspend fun getBusinessNews(): LiveData<List<News>> =
            NewsLiveData.getBusiness()

        suspend fun getAllNews(): LiveData<List<News>> =
            NewsLiveData.getAll()

        suspend fun getTechnologyNews(): LiveData<List<News>> =
            NewsLiveData.getTechnology()

        suspend fun getMiscellaneousNews(): LiveData<List<News>> =
            NewsLiveData.getMiscellaneous()

        suspend fun getNationalNews(): LiveData<List<News>> =
            NewsLiveData.getNational() //Indian News only
    }
}