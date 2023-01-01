package io.bordo.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class EventStatusListDto(
    val status: List<io.bordo.common.data.remote.dto.EventStatusDto>
)