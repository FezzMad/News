package com.example.news.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.news.R
import com.example.news.repository.model.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_news_detail.*


class FragmentDetail : Fragment(R.layout.fragment_news_detail) {

    lateinit var currentNews: News

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        currentNews = arguments?.getSerializable("news") as News

        tvDetailAuthor.text = currentNews.author
        tvDetailContent.text = currentNews.content
        tvDetailTitle.text = currentNews.title
        tvDetailDate.text = currentNews.date
        tvDetailTime.text = currentNews.time
        tvDetailReadMoreUrl.text = currentNews.readMoreUrl

        Picasso.with(context)
            .load(currentNews.imageUrl)
            .error(R.drawable.news_image1)
            .into(ivDetailCard)
    }
}
