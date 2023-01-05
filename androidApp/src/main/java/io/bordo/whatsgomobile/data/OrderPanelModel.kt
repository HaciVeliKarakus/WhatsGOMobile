package io.bordo.whatsgomobile.data

data class OrderPanelModel(
    val pending: String = "0",
    val preparing: String = "37",
    val submission: String = "8",
    val cancelled: String = "4",
    val delivered: String = "8"
)
