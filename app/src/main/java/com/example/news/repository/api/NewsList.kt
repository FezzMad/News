package com.example.news.repository.api

import com.example.news.repository.model.News
import com.example.news.repository.model.ResponseAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsList {
    companion object {
        suspend fun getTechnology(): List<News> = withContext(Dispatchers.IO) {
            getListNews(NewsResponse.getTechnology().body() ?: ResponseAPI())
        }

        suspend fun getAll(): List<News> = withContext(Dispatchers.IO) {
            getListNews(NewsResponse.getAll().body() ?: ResponseAPI())
        }

        suspend fun getBusiness(): List<News> = withContext(Dispatchers.IO) {
            getListNews(NewsResponse.getBusiness().body() ?: ResponseAPI())
        }

        suspend fun getWorld(): List<News> = withContext(Dispatchers.IO) {
            getListNews(NewsResponse.getWorld().body() ?: ResponseAPI())
        }

        suspend fun getSports(): List<News> = withContext(Dispatchers.IO) {
            getListNews(NewsResponse.getSports().body() ?: ResponseAPI())
        }

        suspend fun getPolitics(): List<News> = withContext(Dispatchers.IO) {
            getListNews(NewsResponse.getPolitics().body() ?: ResponseAPI())
        }

        suspend fun getStartup(): List<News> = withContext(Dispatchers.IO) {
            getListNews(NewsResponse.getStartup().body() ?: ResponseAPI())
        }

        suspend fun getEntertainment(): List<News> = withContext(Dispatchers.IO) {
            getListNews(NewsResponse.getEntertainment().body() ?: ResponseAPI())
        }

        suspend fun getMiscellaneous(): List<News> = withContext(Dispatchers.IO) {
            getListNews(NewsResponse.getMiscellaneous().body() ?: ResponseAPI())
        }

        suspend fun getHatke(): List<News> = withContext(Dispatchers.IO) {
            getListNews(NewsResponse.getHatke().body() ?: ResponseAPI())
        }

        suspend fun getScience(): List<News> = withContext(Dispatchers.IO) {
            getListNews(NewsResponse.getScience().body() ?: ResponseAPI())
        }

        suspend fun getAutomobile(): List<News> = withContext(Dispatchers.IO) {
            getListNews(NewsResponse.getAutomobile().body() ?: ResponseAPI())
        }

        suspend fun getNational(): List<News> = withContext(Dispatchers.IO) {
            getListNews(NewsResponse.getNational().body() ?: ResponseAPI())
        }
    }
}