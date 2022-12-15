package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.ui.theme.BarPink


@Composable
fun DelegateStatisticWidget(name: String, progress: Float) {

    Row(modifier = Modifier.padding(vertical = 5.dp)) {
        Text(text = name,
        modifier=Modifier.requiredWidth(150.dp))
        CustomLinearProgressIndicator(progress = progress)
    }
}

@Composable
fun CustomLinearProgressIndicator(
    modifier: Modifier = Modifier,
    progress: Float,
    progressColor: Color = BarPink,
    backgroundColor: Color = Color.Transparent,
    clipShape: Shape = RoundedCornerShape(16.dp)
) {
    Box(
        modifier = modifier
            .clip(clipShape)
            .background(backgroundColor)
            .height(20.dp)
    ) {
        Box(
            modifier = Modifier
                .background(progressColor)
                .fillMaxHeight()
                .fillMaxWidth(progress)
        )
    }
}