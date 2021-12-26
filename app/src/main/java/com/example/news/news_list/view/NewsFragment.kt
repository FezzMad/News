package com.example.news.news_list.view

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.fragment.app.Fragment

import kotlinx.android.synthetic.main.fragment_news_list.*
import kotlinx.coroutines.*

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.*
import com.example.news.isOnline
import com.example.news.news_list.data.Data
import com.example.news.news_list.data.NewsData
import com.example.news.news_list.data.inshortsNews
import com.example.news.news_list.data.inshortsNewsJSON
import com.example.news.openFile
import com.example.news.saveFile
import com.google.gson.Gson

// список (лента) новостей
class NewsList : Fragment(R.layout.fragment_news_list) {

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private var newsList: List<NewsData>? = null
    private var emptyList: List<NewsData> =
        listOf(NewsData(), NewsData(), NewsData(), NewsData())
    private var isLoad: Boolean = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // вывод на экран пустого списка
        recyclerViewNews.layoutManager = LinearLayoutManager(context)
        recyclerViewNews.adapter = NewsRecyclerAdapter(emptyList, requireContext())

        // загрузка сохранённых данных и их вывод (если они есть)
        val json = openFile("newsJSON", requireContext())
        val data = Gson().fromJson(json, Data::class.java)
        if (data != null) {
            newsList = data.data
            recyclerViewNews.adapter = NewsRecyclerAdapter(newsList!!, requireContext())
        }

        // получение и вывод данных
        CoroutineScope(Job()).launch {
            update()
        }

        // обновление списка новостей через Pull To Refresh
        handler = Handler()
        swipeRefreshLayout.setOnRefreshListener {
            runnable = Runnable {
                CoroutineScope(Job()).launch {
                    update()
                }
                swipeRefreshLayout.isRefreshing = false
            }
            handler.postDelayed(
                runnable, 1000.toLong()
            )
        }
        swipeRefreshLayout.setColorSchemeResources(
            R.color.purple_500,
        )


    }

    // получение и вывод данных
    private suspend fun update() {
        if (isOnline(requireContext())) {
            newsList = getNewsList()
            withContext(Dispatchers.Main) {
                if (newsList != null)
                    recyclerViewNews.adapter = NewsRecyclerAdapter(newsList!!, requireContext())
                else
                    recyclerViewNews.adapter = NewsRecyclerAdapter(emptyList, requireContext())
            }
        } else withContext(Dispatchers.Main) {
            Toast.makeText(
                requireContext(),
                R.string.no_internet_connection,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    // запрос, получение и сохранение данных
    private suspend fun getNewsList(): List<NewsData>? = withContext(Dispatchers.IO) {

        // данные для вывода
        val response = inshortsNews().getNewsData("technology").execute()
        val body = response.body()

        // данные для сохранения
        val responseS = inshortsNewsJSON().getJSON("technology").execute()
        val json = responseS.body()!!.string()

        // сохранение
        CoroutineScope(Job()).launch {
            withContext(Dispatchers.IO) {
                saveFile(json, "newsJSON", requireContext())
            }
        }

        return@withContext body?.data
    }

}



