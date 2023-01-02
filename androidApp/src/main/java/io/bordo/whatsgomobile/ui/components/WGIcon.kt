package io.bordo.whatsgomobile.ui.components

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.theme.BlackMain

@Composable
fun WGIcon(
    id: Int,
    tint: Color = BlackMain
) {
    Icon(
        imageVector = ImageVector.vectorResource(
            id = id
        ),
        contentDescription = "icon",
        tint = tint
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGIcon(id = R.drawable.ic_nav_home)
}