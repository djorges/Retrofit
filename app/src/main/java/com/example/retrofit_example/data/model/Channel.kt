package com.example.retrofit_example.data.model

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

class Channel {
    val title:String ?= null
    val description:String ?= null
    val image: Img?= null
    val copyright:String ?= null
    val language:String ?= null
    val managingEditor:String ?= null
    val webMaster:String ?= null
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName="item")
    val items:List<Item> ?= null

    class Item{
        val title:String?= null
        val description:String?= null
        val link:String?= null
        val category:String?= null
        @JacksonXmlProperty(localName="dc:creator")
        val creator:String?= null
        val pubDate:String?= null
        @JacksonXmlProperty(localName="content:encoded")
        val content:String?= null
        @JacksonXmlProperty(localName="media:content")
        val media: Media?= null
        class Media{
            @JacksonXmlProperty(isAttribute = true)
            val url:String?= null
            @JacksonXmlProperty(isAttribute = true)
            val type:String?= null
            @JacksonXmlProperty(isAttribute = true)
            val medium:String?= null
        }
    }
    class Img{
        val url:String?= null
        val title:String?= null
        val link:String?= null
    }
}