package com.example.retrofit_example.data.model

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

class ArticleModel {
    var title: String? = null
    var description: String? = null
    var link: String? = null
    var pubDate: String? = null

    @JacksonXmlProperty(localName = "content:encoded")
    var content: String? = null

    var category: String? = null

    @JacksonXmlProperty(localName = "dc:creator")
    var creator: String? = null

    @JacksonXmlProperty(localName = "media:content")
    var media: MediaModel? = null
}

class MediaModel {
    @JacksonXmlProperty(isAttribute = true)
    var url: String? = null

    @JacksonXmlProperty(isAttribute = true)
    val type: String? = null

    @JacksonXmlProperty(isAttribute = true)
    val medium: String? = null
}