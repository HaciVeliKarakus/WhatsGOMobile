package io.bordo.common.domain.model

@kotlinx.serialization.Serializable
data class Post(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String
)