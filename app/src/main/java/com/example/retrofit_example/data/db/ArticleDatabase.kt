package com.example.retrofit_example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.retrofit_example.data.model.ArticleEntity

@Database(entities = arrayOf(ArticleEntity::class),version = 1)
abstract class ArticleDatabase : RoomDatabase(){
    abstract fun getDao() : ArticleDao
}