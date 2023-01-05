package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.theme.WhiteMain
import io.bordo.whatsgomobile.ui.theme.whatsappGreen

@Composable
fun WGProfilePicture(
    profilePicture: String,
    profilePictureSize: Dp = 50.dp,
    cornerIconId: Int,
    cornerIconColor: Color,
    cornerIconBackColor: Color = WhiteMain
) {
    Box {
        WGImageAsync(
            url = profilePicture,
            modifier = Modifier
                .size(profilePictureSize)
                .clip(CircleShape)
        )
        Box(
            modifier = Modifier
                .width(15.dp)
                .aspectRatio(ratio = 1f)
                .background(color = cornerIconBackColor, shape = CircleShape)
                .align(alignment = Alignment.BottomEnd),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = cornerIconId),
                contentDescription = null,
                modifier = Modifier.padding(all = 2.dp),
                colorFilter = ColorFilter.tint(color = cornerIconColor)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGProfilePicture(
        profilePicture = "",
        cornerIconId = R.drawable.ic_whatsapp_24,
        cornerIconColor = whatsappGreen
    )
}