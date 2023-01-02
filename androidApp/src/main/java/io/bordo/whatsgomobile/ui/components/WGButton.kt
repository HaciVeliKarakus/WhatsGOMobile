package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.ui.theme.primaryColor


@Composable
fun WGButton(
    text: String,
    iconId: Int? = null,
    textColor: Color = Color.White,
    backColor: Color = primaryColor,
    btnHeight: Dp = 48.dp,
    btnCornerRadius: Dp = 24.dp,
    horizontalPadding: Dp = 24.dp,
    onClick: () -> Unit = {},
) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backColor,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(
            size = btnCornerRadius
        ),
        border = BorderStroke(
            width = 0.dp,
            color = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(height = btnHeight)
            .padding(horizontal = horizontalPadding)
    ) {
        iconId?.let {
            WGImage(id = iconId)
        }

        WGText(
            text = " $text",
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewAtomButton() {
    Row {
        WGButton(text = "preview")
    }
}