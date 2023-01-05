package io.bordo.common.domain.model

data class Player(
    val id: Int = 0,
    val name: String = "name",
    val team: String = "team",
    val photoUrl: String = "https://www.shareicon.net/data/128x128/2016/09/15/829466_man_512x512.png",
    val points: Int = 42,
    val currentPrice: Double = 999.999,
    val goalsScored: Int = 10,
    val assists: Int = 5
)