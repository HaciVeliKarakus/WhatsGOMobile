package io.bordo.whatsgomobile.ui.viewmodel.player

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.bordo.common.domain.model.Player
import io.bordo.common.domain.usecase.base.Resource
import io.bordo.common.domain.usecase.player.GetPlayerListUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PlayerViewModel(private val playerUseCase: GetPlayerListUseCase) : ViewModel() {

    private val _state = mutableStateOf(PlayerListState())
    val state: State<PlayerListState> = _state

    init {
        getPlayerList()
    }

    private fun getPlayerList() {
        playerUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PlayerListState(playerList = result.data as List<Player>)
                }
                is Resource.Error -> {
                    _state.value = PlayerListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = PlayerListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getPlayer(playerId: Int): Player? {
        return _state.value.playerList.find { it.id == playerId }
    }

}

//private val _isLoading = MutableLiveData<Boolean>()
//val isLoading: LiveData<Boolean> = _isLoading
//
//private val _playerList = MutableStateFlow<List<Player>>(emptyList())
//val playerList = playerUseCase.invoke()
//}