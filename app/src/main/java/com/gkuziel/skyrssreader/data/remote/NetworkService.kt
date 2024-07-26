package com.gkuziel.skyrssreader.data.remote

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

class NetworkService {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://feeds.skynews.com/feeds/rss/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    private val skyRssService = retrofit.create(SkyRssService::class.java)

    suspend fun getRssWorldFeed() =
        skyRssService.getRssWorldFeed()
}

interface SkyRssService {
    @GET("world")
    suspend fun getRssWorldFeed(): String
}