package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.ui.theme.GrayFrame

@Composable
fun WGCard(
    modifier: Modifier = Modifier,
    cornerShape: Dp = 12.dp,
    elevation: Dp = 0.dp,
    borderStroke: BorderStroke = BorderStroke(width = 1.dp, color = GrayFrame),
    content:  @Composable() (ColumnScope.() -> Unit)
) {
    Card(
        modifier = modifier.padding(all = 16.dp),
        elevation = elevation,
        shape = RoundedCornerShape(size = cornerShape),
        border = borderStroke
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            content()
        }
    }
}