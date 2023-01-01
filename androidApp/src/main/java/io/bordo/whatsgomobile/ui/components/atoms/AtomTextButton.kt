package io.bordo.whatsgomobile.ui.components.atoms

import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import io.bordo.whatsgomobile.ui.theme.BlackMain


@Composable
fun AtomTextButton(
    text: String,
    color: Color = BlackMain,
    fontWeight: FontWeight = FontWeight.Bold,
    onClick: () -> Unit
) {
    TextButton(onClick = onClick) {
        AtomText(
            text = text,
            fontWeight = fontWeight
        )
    }
}