package com.gkuziel.skyrssreader.data

import com.gkuziel.skyrssreader.data.remote.NetworkService
import com.gkuziel.skyrssreader.model.RssItem


class Repository(
    // todo: to be injected
    // todo: add local DB
    val remote: NetworkService = NetworkService()
) {
    suspend fun loadRssWorlds(): List<RssItem> {
        val remoteFeed = remote.getRssWorldFeed()

        // todo: to be removed when the proper parser id added
        return listOf(
            RssItem(
                remoteFeed.toString(),
                "desc",
                "https://www.google.com/",
                "https://banner2.cleanpng.com/20180424/qwq/kisspng-rss-web-feed-computer-icons-feed-5adf845abd7789.3234863615245978507761.jpg"
//                "https://cdn.freebiesupply.com/logos/large/2x/rss-logo-png-transparent.png"
            )
        )
    }
}