package com.example.news.repository.model

import java.io.Serializable

data class SerializableListNews(
    val list: List<News>
): Serializable