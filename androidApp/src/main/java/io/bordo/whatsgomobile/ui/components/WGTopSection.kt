package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.theme.PurpleMain

@Composable
fun WGTopSection(
    headerText:String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(64.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        WGIcon(
            id = R.drawable.ic_nav_home,
            tint = PurpleMain
        )
        WGSpacer(width = 8.dp, height = 0.dp)
        WGText(
            text = headerText,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
        WGIcon(
            id = R.drawable.ic_notification
        )
    }
}