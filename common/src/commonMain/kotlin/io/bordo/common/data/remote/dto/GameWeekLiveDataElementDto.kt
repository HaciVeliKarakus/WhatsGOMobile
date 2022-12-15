package io.bordo.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GameWeekLiveDataElementDto(
    val id: Int,
    val stats: io.bordo.common.data.remote.dto.GameWeekLiveDataElementStatsDto
)