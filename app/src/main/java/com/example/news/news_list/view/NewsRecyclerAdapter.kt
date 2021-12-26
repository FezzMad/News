package com.example.news.news_list.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.news_list.data.NewsData
import com.example.news.saveNewsDataValue
import com.squareup.picasso.Picasso


// адаптер списка (ленты) новостей
class NewsRecyclerAdapter(private val newsData: List<NewsData>, private val context: Context):
    RecyclerView.Adapter<NewsRecyclerAdapter.NewsViewHolder>() {

    // иницилизация view
    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textView: TextView? = null
        var imageView: ImageView? = null

        init {
            textView = itemView.findViewById(R.id.textView)
            imageView = itemView.findViewById(R.id.imageView)
        }

    }

    // иницилизация шаблона для item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(itemView)
    }

    // заполнение view данными и обработка нажатий
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.textView?.text = newsData[position].title
        Picasso.with(context)
            .load(newsData[position].imageUrl)
            .error(R.drawable.news_image)
            .into(holder.imageView)

        // переход на экран (карточку) с информацией и картинкой для отдельной новости
        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(R.id.action_news_list2_to_news_card)
            saveNewsDataValue(newsData,position,context)
        }

        // переход в галерею картинок для новости
        holder.imageView?.setOnClickListener {
            holder.imageView?.findNavController()?.navigate(R.id.action_news_list_to_imageFragment)
            saveNewsDataValue(newsData,position,context)
        }
    }

    override fun getItemCount(): Int = newsData.size
}