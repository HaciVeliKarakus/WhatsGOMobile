package io.bordo.common.data.repository.player

import io.bordo.common.data.remote.ApiService

class PlayerRemoteDataSource(
    private val service: ApiService
) {
    suspend fun getPlayer(playerId: String) = service.fetchPlayerData(playerId)
    suspend fun getBootstrapStaticInfo() = service.fetchBootstrapStaticInfo()
}