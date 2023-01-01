package io.bordo.whatsgomobile.ui.components.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.ui.components.atoms.AtomLinearProgressIndicator


@Composable
fun WidgetDelegateStatistic(
    name: String,
    progress: Float
) {

    Row(modifier = Modifier.padding(vertical = 5.dp)) {
        Text(
            text = name,
            modifier = Modifier.requiredWidth(150.dp)
        )
        AtomLinearProgressIndicator(progress = progress)
    }
}

