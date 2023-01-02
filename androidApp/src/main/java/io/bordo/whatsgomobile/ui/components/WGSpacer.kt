package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun WGSpacer(height: Dp = 16.dp, width: Dp = 0.dp) {
    Spacer(
        modifier = Modifier
            .height(height = height)
            .width(width = width)
    )
}


@Preview
@Composable
private fun AtomSpacerPreview() {
    WGSpacer(height = 16.dp, width = 16.dp)
}