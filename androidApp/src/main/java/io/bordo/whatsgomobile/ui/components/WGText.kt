package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.ui.theme.BlackMain

@Composable
fun WGText(
    text: String,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.Medium,
    color: Color = BlackMain,
    horizontalPadding: Dp = 0.dp,
    textAlign: TextAlign?=null
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontFamily= satoshiFamily,
        color = color,
        textAlign=textAlign,
        modifier = Modifier.padding(horizontal = horizontalPadding)
    )
}

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    WGText(text = "Preview")
}
