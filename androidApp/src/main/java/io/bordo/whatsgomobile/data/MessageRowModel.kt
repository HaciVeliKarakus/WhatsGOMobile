package io.bordo.whatsgomobile.data

import io.bordo.whatsgomobile.data.types.ConsumerType

data class MessageRowModel(
    val imageUrl:String="",
    val agentName: String="agent name",
    val userName: String="user name",
    val preview: String="preview text",
    val date: String="03.08.1997",
    val count:Int=25,
    val consumerType: ConsumerType = ConsumerType.CONSUMER

)