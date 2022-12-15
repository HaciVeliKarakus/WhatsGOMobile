package io.bordo.common.domain.model

data class Player(
    val id: Int,
    val name: String,
    val team: String,
    val photoUrl: String,
    val points: Int,
    val currentPrice: Double,
    val goalsScored: Int,
    val assists: Int
)