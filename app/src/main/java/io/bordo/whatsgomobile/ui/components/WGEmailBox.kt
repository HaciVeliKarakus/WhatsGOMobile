package io.bordo.whatsgomobile.ui.components.edittext

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WGEmailBox() {
    val textFieldState = remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(value = textFieldState.value,
        onValueChange = { textFieldState.value = it },
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        label = {
            Text(
                text = "Mail adresiniz",
                color = Color.LightGray,
                fontSize = 12.sp,
            )
        },
        modifier = Modifier.onFocusChanged { focusState ->
            if (focusState.isFocused) {
                val text = textFieldState.value.text
                textFieldState.value =
                    textFieldState.value.copy(selection = TextRange(0, text.length))
            }
        })
}