package io.bordo.whatsgomobile.ui.screen.dashboard.message.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.bordo.common.domain.model.Player
import io.bordo.common.domain.model.PlayerPastHistory
import io.bordo.whatsgomobile.ui.components.chat.ChatInput
import io.bordo.whatsgomobile.ui.components.chat.ChatTopBar
import io.bordo.whatsgomobile.ui.components.chat.SentMessageRow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

@Composable
fun ChatScreen(
    user: Player,
    popBackStack: () -> Unit
) {
    var playerHistory by remember { mutableStateOf(emptyList<PlayerPastHistory>()) }
    LaunchedEffect(true) {
//        playerHistory = viewModel.getPlayerHistory(user.id)
//        println(playerHistory)
    }

    val messages = remember { mutableStateListOf<ChatMessage>() }
    val sdf = remember { SimpleDateFormat("hh:mm", Locale.ROOT) }

    messages.add(
        ChatMessage(
            id = (messages.size + 1).toLong(),
            message = "Ürününüzden 2 adet satın almak istiyorum. Yardımcı olabilir misiniz?",
            date = System.currentTimeMillis()
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        ChatTopBar(user = user) { popBackStack() }

        val scrollState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()

        LazyColumn(
            state = scrollState,
            contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp)
        ) {
            items(messages) { message: ChatMessage ->

                // Remember random stats icon to not create at each recomposition
                val messageStatus = remember { MessageStatus.values()[Random.nextInt(3)] }

                // Toggle between sent and received message
//                when (message.id.toInt() % 6) {
//                    1 -> {
                SentMessageRow(
                    text = message.message,
//                    quotedMessage = "Quote message",
                    messageTime = sdf.format(System.currentTimeMillis()),
                    messageStatus = messageStatus
                )

            }
        }

        ChatInput(
            onMessageChange = { messageContent ->
                messages.add(
                    ChatMessage(
                        (messages.size + 1).toLong(),
                        messageContent,
                        System.currentTimeMillis()
                    )
                )

                coroutineScope.launch {
                    scrollState.animateScrollToItem(messages.size - 1)
                }

            }
        )
    }
}


data class ChatMessage(
    val id: Long,
    var message: String,
    var date: Long
)

enum class MessageStatus {
    PENDING, RECEIVED, READ
}
