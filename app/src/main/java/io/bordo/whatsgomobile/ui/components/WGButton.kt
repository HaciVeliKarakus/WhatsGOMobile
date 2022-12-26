package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.ui.theme.primaryColor


@Composable
fun WGButton(
    text: String,
    iconId: Int? = null,
    textColor: Color = Color.White,
    backColor: Color = primaryColor,
    bottomSpacer: Dp,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backColor,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        modifier = Modifier
            .height(48.dp)
            .width(300.dp)
    ) {
        iconId?.let {
            Image(
                painterResource(id = iconId),
                contentDescription = null
            )
        }

        Text(
            text = " $text",
            color = textColor
        )
    }
    Spacer(modifier = Modifier.height(bottomSpacer))
}
