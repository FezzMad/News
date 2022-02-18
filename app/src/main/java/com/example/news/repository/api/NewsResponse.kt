package com.example.news.repository.api

import com.example.news.repository.model.Category
import com.example.news.repository.model.ResponseAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class NewsResponse {
    companion object {
        suspend fun getTechnology(): Response<ResponseAPI> = withContext(Dispatchers.IO) {
                getInshortsNews().callDataAPI(Category.TECHNOLOGY).execute()
            }

        suspend fun getAll(): Response<ResponseAPI> = withContext(Dispatchers.IO) {
            getInshortsNews().callDataAPI(Category.ALL).execute()
        }

        suspend fun getBusiness(): Response<ResponseAPI> = withContext(Dispatchers.IO) {
            getInshortsNews().callDataAPI(Category.BUSINESS).execute()
        }

        suspend fun getWorld(): Response<ResponseAPI> = withContext(Dispatchers.IO) {
            getInshortsNews().callDataAPI(Category.WORLD).execute()
        }

        suspend fun getSports(): Response<ResponseAPI> = withContext(Dispatchers.IO) {
            getInshortsNews().callDataAPI(Category.SPORTS).execute()
        }

        suspend fun getPolitics(): Response<ResponseAPI> = withContext(Dispatchers.IO) {
            getInshortsNews().callDataAPI(Category.POLITICS).execute()
        }

        suspend fun getStartup(): Response<ResponseAPI> = withContext(Dispatchers.IO) {
            getInshortsNews().callDataAPI(Category.STARTUP).execute()
        }

        suspend fun getEntertainment(): Response<ResponseAPI> = withContext(Dispatchers.IO) {
            getInshortsNews().callDataAPI(Category.ENTERTAINMENT).execute()
        }

        suspend fun getMiscellaneous(): Response<ResponseAPI> = withContext(Dispatchers.IO) {
            getInshortsNews().callDataAPI(Category.MISCELLANEOUS).execute()
        }

        suspend fun getHatke(): Response<ResponseAPI> = withContext(Dispatchers.IO) {
            getInshortsNews().callDataAPI(Category.HATKE).execute()
        }

        suspend fun getScience(): Response<ResponseAPI> = withContext(Dispatchers.IO) {
            getInshortsNews().callDataAPI(Category.SCIENCE).execute()
        }

        suspend fun getAutomobile(): Response<ResponseAPI> = withContext(Dispatchers.IO) {
            getInshortsNews().callDataAPI(Category.AUTOMOBILE).execute()
        }

        suspend fun getNational(): Response<ResponseAPI> = withContext(Dispatchers.IO) {
            getInshortsNews().callDataAPI(Category.NATIONAL).execute()
        }
    }
}