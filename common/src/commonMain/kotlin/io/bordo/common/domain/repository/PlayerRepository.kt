package io.bordo.common.domain.repository

import io.bordo.common.data.remote.dto.ElementDto
import io.bordo.common.domain.model.PlayerPastHistory

interface PlayerRepository {
    suspend fun getPlayerHistoryData(playerId: String): List<PlayerPastHistory>
    suspend fun loadData(): List<ElementDto>
}