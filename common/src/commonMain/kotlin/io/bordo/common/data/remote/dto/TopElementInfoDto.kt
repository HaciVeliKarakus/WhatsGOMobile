package io.bordo.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TopElementInfoDto(
    val id: Int,
    val points: Int
)