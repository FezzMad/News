package com.example.news.repository

import androidx.lifecycle.LiveData
import com.example.news.repository.api.NewsCategory
import com.example.news.repository.model.News

class GlobalRepository {
    suspend fun getTechnologyNews(): LiveData<List<News>> =
        NewsCategory.getTechnologyNews()

    suspend fun getAutomobileNews(): LiveData<List<News>> =
        NewsCategory.getAutomobileNews()

    suspend fun getScienceNews(): LiveData<List<News>> =
        NewsCategory.getScienceNews()

    suspend fun getHatkeNewsNews(): LiveData<List<News>> =
        NewsCategory.getHatkeNewsNews()

    suspend fun getEntertainmentNewsNews(): LiveData<List<News>> =
        NewsCategory.getEntertainmentNewsNews()

    suspend fun getStartupNews(): LiveData<List<News>> =
        NewsCategory.getStartupNews()

    suspend fun getPoliticsNews(): LiveData<List<News>> =
        NewsCategory.getPoliticsNews()

    suspend fun getSportsNews(): LiveData<List<News>> =
        NewsCategory.getSportsNews()

    suspend fun getWorldNews(): LiveData<List<News>> =
        NewsCategory.getWorldNews()

    suspend fun getBusinessNews(): LiveData<List<News>> =
        NewsCategory.getBusinessNews()

    suspend fun getAllNews(): LiveData<List<News>> =
        NewsCategory.getAllNews()

    suspend fun getMiscellaneousNews(): LiveData<List<News>> =
        NewsCategory.getMiscellaneousNews()

    suspend fun getNationalNews(): LiveData<List<News>> =
        NewsCategory.getNationalNews() //Indian News only
}