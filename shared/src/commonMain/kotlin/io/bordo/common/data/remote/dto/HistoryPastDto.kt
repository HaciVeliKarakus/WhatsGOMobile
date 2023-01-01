package io.bordo.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class HistoryPastDto(
    val season_name: String,
    val total_points: Int
)