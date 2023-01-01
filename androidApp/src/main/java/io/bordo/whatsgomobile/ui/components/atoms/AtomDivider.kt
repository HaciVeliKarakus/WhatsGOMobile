package io.bordo.whatsgomobile.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.ui.theme.GrayMain

@Composable
fun AtomDivider(
    centerText: String?=null,
    horizontalPadding: Dp = 10.dp,
    lineColor: Color = Color.LightGray,
    textColor: Color = GrayMain,
    textBackColor:Color=Color.White
) {
    Box(contentAlignment = Alignment.Center) {
        Divider(
            modifier = Modifier
                .padding(
                    start = horizontalPadding,
                    end = horizontalPadding
                ),
            color = lineColor
        )
        Box(
            modifier = Modifier
                .background(color = textBackColor)
        ) {
            centerText?.let {
                AtomText(
                    text = it,
                    color = textColor,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun PreviewAtomDivider() {
    AtomDivider(centerText = "Preview")
}
