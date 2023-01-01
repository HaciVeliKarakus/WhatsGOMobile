package io.bordo.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LeagueStandingsDto(
    val league: io.bordo.common.data.remote.dto.LeagueDto,
    val standings: io.bordo.common.data.remote.dto.LeagueStandingsResultsDto
)