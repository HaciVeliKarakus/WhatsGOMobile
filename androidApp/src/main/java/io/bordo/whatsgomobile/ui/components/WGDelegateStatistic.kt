package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun WGDelegateStatistic(
    name: String,
    progress: Float
) {

    Row(modifier = Modifier.padding(vertical = 5.dp)) {
        Text(
            text = name,
            modifier = Modifier.requiredWidth(150.dp)
        )
        WGLinearProgressIndicator(progress = progress)
    }
}

