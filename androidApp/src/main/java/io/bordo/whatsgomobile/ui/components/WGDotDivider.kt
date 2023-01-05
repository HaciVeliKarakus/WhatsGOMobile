package io.bordo.whatsgomobile.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun WGDotDivider(
    verticalSpace: Dp = 8.dp,
    horizontalSpace: Dp = 20.dp,
    type:DividerType=DividerType.HorizontalDot
) {
    WGSpacer(height = verticalSpace)
    WGDivider(type = type, horizontalPadding = horizontalSpace)
    WGSpacer(height = verticalSpace)
}