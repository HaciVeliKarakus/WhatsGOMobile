package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun WGImage(id:Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = null
    )
}
