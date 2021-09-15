package com.example.retrofit_example.data.model

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

class ChannelModel{
    val title: String? = null
    val description: String? = null
    val copyright: String? = null
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    val items: List<ArticleModel>? = null
    val image: ImgModel? = null
    val language: String? = null
    val managingEditor: String? = null
    val webMaster: String? = null
}
class ImgModel{
    val url: String? = null
    val title: String? = null
    val link: String? = null
}