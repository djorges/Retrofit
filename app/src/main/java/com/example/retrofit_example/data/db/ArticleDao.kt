package com.example.retrofit_example.data.db

import androidx.room.*
import com.example.retrofit_example.data.model.ArticleEntity

@Dao
interface ArticleDao {
    @Query("SELECT * FROM table_articles")
    suspend fun getArticles(): List<ArticleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(articleEntity: ArticleEntity)

    @Delete
    suspend fun deleteArticle(articleEntity: ArticleEntity)
}