package com.example.news.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.news.R
import com.example.news.isOnline
import com.example.news.pause
import com.example.news.toSerializableListNews
import kotlinx.coroutines.*


class FragmentStart : Fragment(R.layout.fragment_start) {

    private lateinit var viewModel: NewsViewModel
    private lateinit var bundle: Bundle


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.initDatabase()

        bundle = Bundle()

        val context = requireContext()

        if (isOnline(context)) {
            CoroutineScope(Job()).launch {
                withContext(Dispatchers.Main) {
                    viewModel.getTechnologyNews().observe(viewLifecycleOwner) { list ->
                        bundle.putSerializable("list", toSerializableListNews(list))
                        pause()
                        findNavController().navigate(
                            R.id.action_startFragment_to_newsFragment,
                            bundle
                        )
                    }
                }
                viewModel.insertAllNews(viewModel.getTechnologyNews())
            }
        } else {
            viewModel.loadAllNews().observe(viewLifecycleOwner) { list ->
                bundle.putSerializable("list", toSerializableListNews(list))
                pause()
                findNavController().navigate(R.id.action_startFragment_to_newsFragment, bundle)
            }
        }
    }
}