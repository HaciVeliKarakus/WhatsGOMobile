package io.bordo.common.data.remote

import io.bordo.common.data.remote.dto.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent


class ApiService(
    private val client: HttpClient,
    private val baseUrl: String = "https://fantasy.premierleague.com/api",
) : KoinComponent {

    suspend fun fetchBootstrapStaticInfo() = client.get("$baseUrl/bootstrap-static/").body<BootstrapStaticInfoDto>()
    suspend fun fetchFixtures() = client.get("$baseUrl/fixtures").body<List<FixtureDto>>()
    suspend fun fetchUpcomingFixtures() = client.get("$baseUrl/fixtures?future=1").body<List<FixtureDto>>()
    suspend fun fetchGameWeekLiveData(eventId: Int) = client.get("$baseUrl/event/$eventId/live/").body<GameWeekLiveDataDto>()
    suspend fun fetchPlayerData(playerId: String) = client.get("$baseUrl/element-summary/$playerId/").body<ElementSummaryDto>()
    suspend fun fetchLeagueStandings(leagueId: Int) = client.get("$baseUrl/leagues-classic/$leagueId/standings/").body<LeagueStandingsDto>()
    suspend fun fetchEventStatus() = client.get("$baseUrl/event-status/").body<EventStatusListDto>()
}
