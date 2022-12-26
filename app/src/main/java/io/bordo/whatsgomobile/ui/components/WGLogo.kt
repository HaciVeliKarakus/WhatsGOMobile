package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import io.bordo.whatsgomobile.R

@Composable
fun WGLogo(
    bottomSpacer: Dp
) {
    Image(
        painterResource(id = R.drawable.logo_name_main),
        contentDescription = null
    )
    Spacer(modifier = Modifier.height(bottomSpacer))
}
