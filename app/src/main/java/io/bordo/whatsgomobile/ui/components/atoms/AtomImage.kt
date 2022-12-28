package io.bordo.whatsgomobile.ui.components.atoms

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun AtomImage(id:Int) {
    Image(
        painterResource(id = id),
        contentDescription = null
    )
}
