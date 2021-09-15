package com.example.retrofit_example.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_articles")
data class ArticleEntity(
    @PrimaryKey
    @ColumnInfo(name = "article_title")
    val title:String,
    @ColumnInfo(name = "article_description")
    val description:String?= null,
    @ColumnInfo(name = "article_link")
    val link:String?= null,
    @ColumnInfo(name = "article_date")
    val pubDate:String?= null,
    @ColumnInfo(name = "article_content")
    val content:String?= null,
    @ColumnInfo(name = "article_image")
    val imgUrl:String?= null
)
