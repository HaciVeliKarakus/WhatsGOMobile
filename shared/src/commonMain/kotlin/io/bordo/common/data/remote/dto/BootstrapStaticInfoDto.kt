package io.bordo.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class BootstrapStaticInfoDto(
    val element_stats: List<ElementStatDto>,
    val element_types: List<ElementTypeDto>,
    val elements: List<ElementDto>,
    val events: List<EventDto>,
    val game_settings: GameSettingsDto,
    val phases: List<PhaseDto>,
    val teams: List<TeamDto>,
    val total_players: Int
)