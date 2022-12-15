package io.bordo.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GameWeekLiveDataDto(
    val elements: List<io.bordo.common.data.remote.dto.GameWeekLiveDataElementDto>
)