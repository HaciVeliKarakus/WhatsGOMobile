package io.bordo.whatsgomobile.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun BigText(text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
    )
}

@Composable
fun SmallText(text: String) {
    Text(
        text = text,
        fontSize = 10.sp,
        fontWeight = FontWeight.W900
    )
}

