package io.bordo.common.domain.usercase.player

import io.bordo.common.data.remote.dto.toPlayer
import io.bordo.common.domain.model.Player
import io.bordo.common.domain.repository.PlayerRepository
import io.bordo.common.domain.usercase.base.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPlayerListUseCase(
    private val repository: PlayerRepository
) {
    operator fun invoke(): Flow<Resource<List<Player>>> = flow {
        try {
            emit(Resource.Loading())
            val playerList = repository.loadData().map { it.toPlayer() }
            emit(Resource.Success(playerList))
        } catch(e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occured"))
        }
    }
}