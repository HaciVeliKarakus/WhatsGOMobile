package io.bordo.common.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LeagueResultDto(
    val id: Int,
    val rank: Int,
    @SerialName("last_rank")
    val lastRank: Int,
    @SerialName("event_total")
    val eventTotal: Int,
    val total: Int,
    @SerialName("player_name")
    val playerName: String,
    @SerialName("entry_name")
    val entryName: String
)