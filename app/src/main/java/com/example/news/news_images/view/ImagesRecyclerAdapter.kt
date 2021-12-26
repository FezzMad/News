package com.example.news.news_images.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R

import com.example.news.news_list.data.NewsData
import com.squareup.picasso.Picasso


// адаптер для галереи картинки (картинок)
class ImagesRecyclerAdapter(private val newsData: List<NewsData>, private val context: Context):
    RecyclerView.Adapter<ImagesRecyclerAdapter.NewsViewHolder>() {

    // иницилизация view
    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imageViewI: ImageView? = null

        init {
            imageViewI = itemView.findViewById(R.id.imageViewInList)
        }

    }

    // иницилизация шаблона для item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.images_item, parent, false)
        return NewsViewHolder(itemView)
    }

    // заполнение view данными
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        Picasso.with(context)
            .load(newsData[position].imageUrl)
            .error(R.drawable.news_image)
            .into(holder.imageViewI)

    }

    override fun getItemCount(): Int = newsData.size
}