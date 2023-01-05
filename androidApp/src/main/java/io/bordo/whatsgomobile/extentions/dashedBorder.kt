package io.bordo.whatsgomobile.extentions

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.ui.theme.GrayMain

fun Modifier.dashedBorder(
    width: Dp = 1.dp,
    radius: Dp = 0.dp,
    color: Color = GrayMain
) = drawBehind {
    drawIntoCanvas {
        val paint = Paint()
            .apply {
                strokeWidth = width.toPx()
                this.color = color
                style = PaintingStyle.Stroke
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
            }
        it.drawRoundRect(
            width.toPx()/2,
            width.toPx()/2,
            size.width - width.toPx()/2,
            size.height - width.toPx()/2,
            radius.toPx(),
            radius.toPx(),
            paint
        )
    }
}

