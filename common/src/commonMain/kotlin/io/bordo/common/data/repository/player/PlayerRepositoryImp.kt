package io.bordo.common.data.repository.player

import com.rickclephas.kmp.nativecoroutines.NativeCoroutineScope
import io.bordo.common.data.remote.dto.BootstrapStaticInfoDto
import io.bordo.common.data.remote.dto.ElementDto
import io.bordo.common.domain.model.Player
import io.bordo.common.domain.model.PlayerPastHistory
import io.bordo.common.domain.repository.PlayerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlayerRepositoryImp(
    private val remoteDataSource: PlayerRemoteDataSource,
//    private val localDataSource: PlayerLocalDataSource
) : PlayerRepository {

//    private val _playerList = MutableStateFlow<List<Player>>(emptyList())
//    val playerList = localDataSource.playerList

    @NativeCoroutineScope
    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    init {
        coroutineScope.launch {
            loadData()
//            launch {
//                localDataSource.loadFromDb()
//                println("size:${playerList.value.size}")

//            }
        }
    }

    override suspend fun getPlayerHistoryData(playerId: String): List<PlayerPastHistory> {
        return remoteDataSource.getPlayer(playerId).history_past.map {
            PlayerPastHistory(it.season_name, it.total_points)
        }
    }

    override suspend fun loadData(): List<ElementDto> {
        return remoteDataSource.getBootstrapStaticInfo().elements
//        try {
//            println("enter")
//            val bootstrapStaticInfoDto = remoteDataSource.getBootstrapStaticInfo()
//            localDataSource.writeDataToDb(bootstrapStaticInfoDto)
//        } catch (e: Exception) {
//            println("error")
//        }
    }
}