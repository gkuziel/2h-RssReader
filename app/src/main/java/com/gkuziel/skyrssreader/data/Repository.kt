package com.gkuziel.skyrssreader.data

import com.gkuziel.skyrssreader.data.remote.NetworkService
import com.gkuziel.skyrssreader.model.RssItem


class Repository(
    val remote: NetworkService = NetworkService()
) {
    suspend fun loadRssWorlds(): List<RssItem> {
        val remoteFeed = remote.getRssWorldFeed()
        return listOf(
            RssItem(
                remoteFeed,
                "desc",
                "https://www.google.com/",
                "https://cdn.freebiesupply.com/logos/large/2x/rss-logo-png-transparent.png"
            )
        )
    }
}