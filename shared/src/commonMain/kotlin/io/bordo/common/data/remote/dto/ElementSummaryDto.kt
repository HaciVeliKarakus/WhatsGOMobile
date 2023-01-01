package io.bordo.common.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ElementSummaryDto(
    val history_past: List<io.bordo.common.data.remote.dto.HistoryPastDto>
)