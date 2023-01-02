package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.ui.theme.GrayFrame
import io.bordo.whatsgomobile.ui.theme.GrayMain

@Composable
fun WGEditText(
    textFieldState: MutableState<TextFieldValue>,
    cornerRadius: Dp = 12.dp,
    horizontalPadding: Dp = 24.dp,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    hintText: String? = null,
    hintTextColor: Color = GrayMain,
    borderStrokeColor: Color = GrayFrame,
    trailingIcon: @Composable() (() -> Unit)? = null,
) {
    TextField(
        value = textFieldState.value,
        onValueChange = { textFieldState.value = it },
        shape = RoundedCornerShape(cornerRadius),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        label = {
            hintText?.let {
                WGText(
                    text = it,
                    color = hintTextColor
                )
            }
        },
        trailingIcon = trailingIcon,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding)
            .clip(RoundedCornerShape(size = cornerRadius))
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = borderStrokeColor
                ),
                shape = RoundedCornerShape(size = cornerRadius)
            )
            .onFocusChanged { focusState ->
                if (focusState.isFocused) {
                    val text = textFieldState.value.text
                    textFieldState.value =
                        textFieldState.value.copy(
                            selection = TextRange(start = 0, end = text.length)
                        )
                }
            },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        )
    )
}
