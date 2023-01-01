package io.bordo.whatsgomobile.ui.components.widgets

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import io.bordo.whatsgomobile.ui.components.atoms.AtomEditText

@Composable
fun WidgetPasswordBox(hintText: String) {
    val password = remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by remember { mutableStateOf(false) }

    val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

    val description = if (passwordVisible) "Hide password" else "Show password"

    AtomEditText(
        textFieldState = password,
        keyboardType = KeyboardType.Password,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        hintText = hintText,
        trailingIcon = {
            IconButton(
                onClick = { passwordVisible = !passwordVisible }
            ) {
                Icon(imageVector = image, description)
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
private fun Preview(){
    WidgetPasswordBox("Şifreniz")
}