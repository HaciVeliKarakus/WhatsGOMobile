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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AtomDivider(
    centerText: String,
    horizontalPadding: Dp = 10.dp
) {
    Box(contentAlignment = Alignment.Center) {
        Divider(
            modifier = Modifier
                .padding(start = horizontalPadding, end = horizontalPadding),
            color = Color.LightGray
        )
        Box(
//            modifier = Modifier.background(Color.White)
        ) {
            Text(
                text = centerText,
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun PreviewAtomDivider(){
    AtomDivider(centerText = "Preview")
}
