package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun WGImage(
    id: Int,
    modifier: Modifier=Modifier
) {
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        modifier = modifier
    )
}
