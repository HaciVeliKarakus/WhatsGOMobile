package io.bordo.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class EventStatusDto(
    val event: Int,
    val date: String,
    val bonus_added: Boolean
)