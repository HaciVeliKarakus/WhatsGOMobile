package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WGDivider(
    centerText:String,
    topSpacer: Dp,
    bottomSpacer:Dp
) {
    Spacer(modifier = Modifier.height(topSpacer))
    Box(contentAlignment = Alignment.Center) {
        Divider(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .width(300.dp),
            color = Color.LightGray
        )
        Box(
            modifier = Modifier.background(Color.White)
        ) {
            Text(
                text = centerText,
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }
    }
    Spacer(modifier = Modifier.height(bottomSpacer))
}