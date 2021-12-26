package com.example.news.news_card.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.news.R
import com.example.news.loadNewsDataValue
import com.example.news.loadStrValue
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_news_card.*

// экран (карточка) с информацией и картинкой для отдельной новости
class NewsCard : Fragment(R.layout.fragment_news_card) {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // загрузка данных для вывода
        val newsData = loadNewsDataValue(requireContext())

        // вывод данных на экран
        textViewDate.text = newsData.date
        textViewTime.text = newsData.time
        textViewAuthor.text = newsData.author
        textViewContent.text = newsData.content
        textViewReadMoreUrl.text = newsData.readMoreUrl

        // вывод картинки на экран
        Picasso.with(context)
            .load(newsData.imageUrl)
            .error(R.drawable.news_image)
            .into(imageViewCard)

        // переход в галерею картинок для новости
        imageViewCard.setOnClickListener {
            findNavController().navigate(R.id.action_news_card_to_imageFragment)
        }

    }


}