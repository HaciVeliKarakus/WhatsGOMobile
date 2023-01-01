package io.bordo.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LeagueStandingsResultsDto(
    val results: List<io.bordo.common.data.remote.dto.LeagueResultDto>
)