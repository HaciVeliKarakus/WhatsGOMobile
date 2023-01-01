package io.bordo.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ElementStatDto(
    val label: String,
    val name: String
)