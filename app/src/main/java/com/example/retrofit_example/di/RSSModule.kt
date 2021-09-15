package com.example.retrofit_example.di

import android.content.Context
import androidx.room.Room
import com.ctc.wstx.stax.WstxInputFactory
import com.example.retrofit_example.data.api.RSSMap
import com.example.retrofit_example.data.db.ArticleDatabase
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton
import javax.xml.stream.XMLInputFactory

@Module
@InstallIn(SingletonComponent::class)
class RSSModule{
    @Provides
    @Singleton
    fun provideService(): RSSMap{
        /* Turn off namespace processing for Stax processor*/
        val input = WstxInputFactory()
        input.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false)

        /*Setup XML Module*/
        val mapper: ObjectMapper = XmlMapper(input)
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        return Retrofit.Builder()
            .baseUrl(RSS_URL)
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .build()
            .create(RSSMap::class.java)
    }
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : ArticleDatabase {
        return Room.databaseBuilder(
            context,
            ArticleDatabase::class.java,
            DB_NAME
        ).build()
    }

    companion object{
        private const val RSS_URL:String = "https://www.pagina12.com.ar/"
        private const val DB_NAME:String = "database_article"
    }
}