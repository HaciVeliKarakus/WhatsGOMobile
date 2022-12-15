package io.bordo.common.data.repository.player

import io.bordo.common.data.local.PlayerDb
import io.bordo.common.data.local.TeamDb
import io.bordo.common.data.remote.dto.BootstrapStaticInfoDto
import io.bordo.common.domain.model.Player
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PlayerLocalDataSource : KoinComponent {
    private val realm: Realm by inject()

    private val _playerList = MutableStateFlow<List<Player>>(emptyList())
    val playerList = _playerList.asStateFlow()

    suspend fun writeDataToDb(
        bootstrapStaticInfoDto: BootstrapStaticInfoDto
    ) {
        realm.write {
            bootstrapStaticInfoDto.elements.forEach { player ->
                copyToRealm(
                    PlayerDb().apply {
                        id = player.id
                        firstName = player.first_name
                        secondName = player.second_name
                        code = player.code
                        teamCode = player.team_code
                        totalPoints = player.total_points
                        nowCost = player.now_cost
                        goalsScored = player.goals_scored
                        assists = player.assists

                        team = query<TeamDb>("code = $0", player.team_code).first().find()
                    }, updatePolicy = UpdatePolicy.ALL
                )
            }
        }
    }

    suspend fun loadFromDb() {
        return realm.query<PlayerDb>().asFlow()
            .map { it.list }
            .collect { it: RealmResults<PlayerDb> ->
                _playerList.value = it.toList().map {
                    val playerName = "${it.firstName} ${it.secondName}"
                    val playerImageUrl =
                        "https://resources.premierleague.com/premierleague/photos/players/110x140/p${it.code}.png"
                    val teamName = it.team?.name ?: ""
                    val currentPrice = it.nowCost / 10.0

                    Player(
                        it.id,
                        playerName,
                        teamName,
                        playerImageUrl,
                        it.totalPoints,
                        currentPrice,
                        it.goalsScored,
                        it.assists
                    )
                }
            }
    }
}
