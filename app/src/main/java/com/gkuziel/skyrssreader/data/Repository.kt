package com.gkuziel.skyrssreader.data

import com.gkuziel.skyrssreader.data.remote.NetworkService


class Repository(
    val remote: NetworkService = NetworkService()
) {
    suspend fun loadRssWorlds() = remote.getRssWorldFeed()
}