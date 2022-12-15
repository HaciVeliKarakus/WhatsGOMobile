package io.bordo.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ChipPlayDto(
    val chip_name: String,
    val num_played: Int
)