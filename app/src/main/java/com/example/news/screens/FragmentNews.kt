package com.example.news.screens

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.news.R
import com.example.news.adapter.NewsAdapter
import com.example.news.isOnline

import com.example.news.repository.model.SerializableListNews

import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.coroutines.*

class FragmentNews : Fragment(R.layout.fragment_news) {

    private lateinit var viewModel: NewsViewModel
    private lateinit var adapter: NewsAdapter

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.initDatabase()

        adapter = NewsAdapter(requireContext())
        recyclerViewNews.adapter = adapter

        val listNews = arguments?.getSerializable("list") as SerializableListNews
        adapter.setList(listNews.list.asReversed())

        val context = requireContext()
        handler = Handler()

        swipeRefreshLayout.setOnRefreshListener {
            runnable = Runnable {

                if (isOnline(context)) {
                    CoroutineScope(Job()).launch {
                        withContext(Dispatchers.Main) {
                            viewModel.getTechnologyNews().observe(viewLifecycleOwner) { list ->
                                adapter.setList(list.asReversed())
                            }
                        }
                        viewModel.insertAllNews(viewModel.getTechnologyNews())
                    }
                } else {
                    Toast.makeText(context, R.string.no_internet_connection, Toast.LENGTH_SHORT)
                        .show()
                }
                swipeRefreshLayout.isRefreshing = false
            }

            handler.postDelayed(
                runnable, 1000.toLong()
            )

            swipeRefreshLayout.setColorSchemeResources(
                R.color.red,
            )
        }
    }
}



