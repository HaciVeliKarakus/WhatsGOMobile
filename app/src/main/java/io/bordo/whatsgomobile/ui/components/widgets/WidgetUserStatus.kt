package io.bordo.whatsgomobile.ui.components.widgets

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.ui.theme.BtnGrayDark
import io.bordo.whatsgomobile.ui.theme.BtnGrayLight
import io.bordo.whatsgomobile.ui.theme.BtnGreenDark
import io.bordo.whatsgomobile.ui.theme.BtnGreenLight


@Composable
fun WidgetUserStatus(
    isOnline: Boolean,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.width(120.dp),
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isOnline) BtnGreenLight else BtnGrayLight,
            contentColor = if (isOnline) BtnGreenDark else BtnGrayDark
        )
    ) {
        Text(
            text = if (isOnline) "Çevrimiçi" else "Çevrimdışı",
            fontSize = 10.sp
        )
    }
}

