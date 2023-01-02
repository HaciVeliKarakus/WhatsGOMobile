package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.data.InfoPack
import io.bordo.whatsgomobile.ui.theme.GrayFrame
import io.bordo.whatsgomobile.R

@Composable
fun WGMessagePanel(
    headerText: String = "Mesajlar",
    waitingMessageInfo: InfoPack,
    activeMessageInfo: InfoPack,
    newMessageInfo: InfoPack,
    doneMessageInfo: InfoPack
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(size = 10.dp),
        border = BorderStroke(width = 1.dp, color = GrayFrame)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            WGText(
                text = headerText,
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
                    WGInfoModule(waitingMessageInfo)
                    WGSpacer()
                    WGInfoModule(newMessageInfo)
                }
                Column {
                    WGInfoModule(activeMessageInfo)
                    WGSpacer()
                    WGInfoModule(doneMessageInfo)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGMessagePanel(
        waitingMessageInfo = InfoPack(imageId = R.drawable.resource_new),
        activeMessageInfo = InfoPack(imageId = R.drawable.resource_new),
        newMessageInfo = InfoPack(imageId = R.drawable.resource_new),
        doneMessageInfo = InfoPack(imageId = R.drawable.resource_new)
    )
}