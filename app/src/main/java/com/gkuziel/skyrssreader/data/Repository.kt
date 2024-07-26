package com.gkuziel.skyrssreader.data

import com.gkuziel.skyrssreader.data.remote.NetworkService
import com.gkuziel.skyrssreader.model.RssItem
import tw.ktrssreader.kotlin.parser.RssStandardParser


class Repository(
    // todo: to be injected
    // todo: add local DB
    private val remote: NetworkService = NetworkService(),
    private val parser: RssStandardParser = RssStandardParser()
) {
    suspend fun loadRssWorlds(): List<RssItem> {
        val remoteFeed = remote.getRssWorldFeed()
        // todo: to be removed when the proper parser id added
        return parser.parse(remoteFeed).items?.map {
            RssItem(
                it.title,
                it.description,
                it.link,
                it.enclosure?.url
            )
        } ?: emptyList()
    }
}