package com.example.news.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.news.repository.model.News

@Database(entities = [News::class], version = 1)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun getNewsRoomDao(): NewsDao

    companion object {
        private var database: NewsDatabase?= null

        @Synchronized
        fun getInstance(context: Context): NewsDatabase {
            return if(database == null) {
                database = Room.databaseBuilder(context, NewsDatabase::class.java, "db_news").build()
                database as NewsDatabase
            } else {
                database as NewsDatabase
            }
        }
    }
}