package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.data.MessageRowModel
import io.bordo.whatsgomobile.ui.theme.BtnGreenLight
import io.bordo.whatsgomobile.ui.theme.GrayMain
import io.bordo.whatsgomobile.ui.theme.primaryColor
import io.bordo.whatsgomobile.ui.theme.whatsappGreen

@Composable
fun WGMessageRow(message: MessageRowModel, horizontalSpace: Dp) {
    Column(modifier = Modifier.padding(horizontal = horizontalSpace)) {
        Row {
            WGProfilePicture(
                profilePicture = message.imageUrl,
                cornerIconId = R.drawable.ic_whatsapp_24,
                cornerIconColor = whatsappGreen
            )
            WGSpacer(width = 8.dp, height = 0.dp)
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    WGText(
                        text = message.userName,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = message.date,
                        fontSize = 10.sp, color = Color.LightGray
                    )

                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    WGText(
                        text = message.preview,
                        color = GrayMain
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(
                                color = primaryColor,
                                shape = CircleShape
                            )
                            .layout { measurable, constraints ->
                                // Measure the composable
                                val placeable = measurable.measure(constraints)

                                //get the current max dimension to assign width=height
                                val currentHeight = placeable.height
                                val currentWidth = placeable.width
                                val newDiameter = maxOf(currentHeight, currentWidth)

                                //assign the dimension and the center position
                                layout(newDiameter, newDiameter) {
                                    // Where the composable gets placed
                                    placeable.placeRelative(
                                        (newDiameter - currentWidth) / 2,
                                        (newDiameter - currentHeight) / 2
                                    )
                                }
                            }
                    ) {
                        Text(
                            text = message.count.toString(),
                            fontSize = 10.sp,
                            color = Color.White,
                            modifier = Modifier.padding(1.dp)
                        )
                    }
                }
            }
        }
        WGSpacer(height = 8.dp)
        Row(verticalAlignment = Alignment.CenterVertically) {
            WGIcon(id = R.drawable.ic_agent, tint = GrayMain)
            WGText(text = message.agentName, fontSize = 12.sp, color = GrayMain)
            Spacer(modifier = Modifier.weight(1f))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(
                        color = BtnGreenLight,
                        shape = CircleShape
                    )
            ) {
                Text(
                    text = message.consumerType.mean,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(horizontal = 3.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGMessageRow(
        message = MessageRowModel(),
        horizontalSpace = 16.dp
    )
}
