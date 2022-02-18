package com.example.news.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.repository.model.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*


class NewsAdapter(private val context: Context):
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var listNews = emptyList<News>()

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.itemView.tvTitle.text = listNews[position].title
        holder.itemView.tvDate.text = listNews[position].date
        holder.itemView.tvTime.text = listNews[position].time

        Picasso.with(context)
            .load(listNews[position].imageUrl)
            .error(R.drawable.news_image1)
            .into(holder.itemView.ivPreview)
    }

    override fun onViewAttachedToWindow(holder: NewsViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("news",listNews[holder.adapterPosition])
            holder.itemView.findNavController().navigate(R.id.action_newsFragment_to_newsDetailFragment,bundle)
        }
    }

    override fun onViewDetachedFromWindow(holder: NewsViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<News>) {
        listNews = list
        notifyDataSetChanged()
    }
}