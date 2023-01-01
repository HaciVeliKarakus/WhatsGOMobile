package io.bordo.whatsgomobile.ui.viewmodel.player

import io.bordo.common.domain.model.Player

data class PlayerListState(
    val isLoading: Boolean = false,
    val playerList: List<Player> = emptyList(),
    val error: String? = null
)
