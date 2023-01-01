package io.bordo.whatsgomobile.ui.components.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import io.bordo.whatsgomobile.ui.components.atoms.AtomEditText

@Composable
fun WidgetEmailBox(hintText: String) {
    val textFieldState = remember { mutableStateOf(TextFieldValue("")) }

    AtomEditText(
        textFieldState = textFieldState,
        keyboardType = KeyboardType.Email,
        hintText = hintText,
    )
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    Row {
        WidgetEmailBox("preview")
    }
}