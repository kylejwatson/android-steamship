package com.kyle.android_steamship

class SteamRepository constructor(
    private val steamService: SteamService
) {
    suspend fun getFriendsOfId(id: String): List<Player> {
        return steamService.getFriends(id)
    }
}
