package com.example.news.news_images.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.R
import com.example.news.loadStrValue
import com.example.news.news_list.data.NewsData
import kotlinx.android.synthetic.main.fragment_image_fragment.*

// галерея картинки (картинок) для новости
class ImageFragment : Fragment(R.layout.fragment_image_fragment) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // загрузка url картинки
        val imageUrl = loadStrValue("imageUrl", requireContext())

        // лист картинок
        val newsList = if (imageUrl != null)
            listOf(NewsData(imageUrl = imageUrl), NewsData(imageUrl = imageUrl))
        else
            listOf(NewsData(), NewsData())

        // отображение картинок на экране
        recyclerViewImages.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewImages.adapter = ImagesRecyclerAdapter(newsList, requireContext())
    }


}