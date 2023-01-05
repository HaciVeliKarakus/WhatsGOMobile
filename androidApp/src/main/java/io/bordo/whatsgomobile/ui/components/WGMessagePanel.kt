package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.data.MessagePanelModel

@Composable
fun WGMessagePanel(
    messagePanelModel: MessagePanelModel
) {
    WGCard {
        WGText(
            text = "Mesajlar",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column {
                WGInfoModule(
                    imageId = R.drawable.waiting,
                    title = "Bekleyen",
                    value = messagePanelModel.waitingMessageCount
                )
                WGSpacer()
                WGInfoModule(
                    imageId = R.drawable.resource_new,
                    title = "Yeni",
                    value = messagePanelModel.newMessageCount
                )
            }
            Column {
                WGInfoModule(
                    imageId = R.drawable.active,
                    title = "Aktif",
                    value = messagePanelModel.activeMessageCount
                )
                WGSpacer()
                WGInfoModule(
                    imageId = R.drawable.completed,
                    title = "Sonlanan",
                    value = messagePanelModel.terminatedMessageCount
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGMessagePanel(
        messagePanelModel = MessagePanelModel()
    )
}