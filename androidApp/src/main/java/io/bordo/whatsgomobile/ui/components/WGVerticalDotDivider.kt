package io.bordo.whatsgomobile.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun WGVerticalDotDivider(
    verticalSpace: Dp = 8.dp,
    horizontalSpace: Dp = 2.dp,
    type:DividerType=DividerType.VerticalDot
) {
    WGSpacer(width = horizontalSpace)
    WGDivider(type = type, verticalPadding = verticalSpace)
    WGSpacer(width = horizontalSpace)
}