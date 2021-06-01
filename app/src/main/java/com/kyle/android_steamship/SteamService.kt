package com.kyle.android_steamship

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SteamService {
    @GET("/friendSummary")
    suspend fun getFriends(@Query("steamid") steamId: String): List<Player>
}