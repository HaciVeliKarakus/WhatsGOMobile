package io.bordo.whatsgomobile.ui.components.atoms

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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.ui.theme.primaryColor
import io.bordo.whatsgomobile.ui.utils.toDp


@Composable
fun AtomButton(
    text: String,
    iconId: Int? = null,
    textColor: Color = Color.White,
    backColor: Color = primaryColor,
    btnHeight: Dp = 44.dp,
    btnWidth: Dp? = null,
    btnCornerRadius:Dp=10.dp,
    onClick: () -> Unit={},
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backColor,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(btnCornerRadius),
        border = BorderStroke(1.dp, Color.LightGray)
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
}

@Preview
@Composable
fun PreviewAtomButton(){
    AtomButton(text = "preview")
}