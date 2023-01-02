package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.ui.theme.GrayMain

@Composable
fun WGDivider(
    centerText: String? = null,
    type: DividerType = DividerType.Line,
    horizontalPadding: Dp = 10.dp,
    color: Color = Color.LightGray,
    textColor: Color = GrayMain,
    textBackColor: Color = Color.White
) {
    Box(contentAlignment = Alignment.Center) {
        if (type == DividerType.Line) {
            Divider(
                modifier = Modifier
                    .padding(
                        horizontal = horizontalPadding
                    ),
                color = color
            )
        } else if (type == DividerType.Dot) {
            val pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(10f, 10f),
                phase = 0f
            )
            Canvas(
                Modifier
                    .fillMaxWidth()
                    .height(height = 1.dp)
            ) {
                drawLine(
                    color = color,
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = size.width, y = 0f),
                    pathEffect = pathEffect
                )
            }
        }
        Box(
            modifier = Modifier
                .background(color = textBackColor)
        ) {
            centerText?.let {
                WGText(
                    text = it,
                    color = textColor,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

class DividerType(type: String) {
    companion object {
        val Dot = DividerType("dot")
        val Line = DividerType("line")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAtomDivider() {
    WGDivider(type = DividerType.Dot, color = Color.Black)
}
