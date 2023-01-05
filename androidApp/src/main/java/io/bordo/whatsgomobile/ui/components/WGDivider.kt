package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import io.bordo.whatsgomobile.ui.theme.GrayBackground
import io.bordo.whatsgomobile.ui.theme.GrayMain

@Composable
fun WGDivider(
    centerText: String? = null,
    type: DividerType = DividerType.HorizontalLine,
    horizontalPadding: Dp = 10.dp,
    verticalPadding:Dp=0.dp,
    color: Color = Color.LightGray,
    textColor: Color = GrayMain,
    textBackColor: Color = GrayBackground
) {
    Box(contentAlignment = Alignment.Center) {
        when (type) {
            DividerType.HorizontalLine, DividerType.VerticalLine -> {
                Divider(
                    modifier = Modifier
                        .padding(
                            horizontal = horizontalPadding,
                            vertical = verticalPadding
                        ),
                    color = color
                )
            }
            DividerType.HorizontalDot, DividerType.VerticalDot -> {
                val pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(10f, 10f),
                    phase = 0f
                )
                Canvas(
                    modifier = when (type) {
                        DividerType.HorizontalDot -> Modifier
                            .fillMaxWidth()
                            .height(height = 1.dp)
                        else -> Modifier.width(1.dp)
                    }
                ) {
                    drawLine(
                        color = color,
                        start = Offset(x = 0f, y = 0f),
                        end = Offset(
                            x = if (type == DividerType.HorizontalDot) size.width else 0f,
                            y = if (type == DividerType.HorizontalDot) 0f else size.height
                        ),
                        pathEffect = pathEffect
                    )
                }
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
        val VerticalDot = DividerType("vertical_dot")
        val HorizontalDot = DividerType("vertical_dot")

        val VerticalLine = DividerType("vertical_line")
        val HorizontalLine = DividerType("horizontal_line")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAtomDivider() {
    WGDivider(type = DividerType.HorizontalDot, color = Color.Black)
}
