package io.bordo.whatsgomobile.extentions

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import io.bordo.whatsgomobile.ui.theme.GrayLight
import io.bordo.whatsgomobile.ui.theme.GrayMain

fun Modifier.drawVerticalDotLine() = drawBehind {
    drawLine(
        color = GrayLight,
        start = Offset(size.width, 0f),
        end = Offset(size.width, size.height),
        strokeWidth = 4f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )
}