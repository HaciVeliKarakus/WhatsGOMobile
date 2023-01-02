package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.data.InfoPack

@Composable
fun WGInfoModule(
    infoPack: InfoPack,
    spaceBetweenImageAndText: Dp = 10.dp
) {
    var isNeedSpace by remember { mutableStateOf(false) }
    Row {

        infoPack.imageId?.let {
            WGImage(id = it)
            isNeedSpace = !isNeedSpace
        }

        Column(
            modifier = Modifier.padding(
                horizontal = if (isNeedSpace) spaceBetweenImageAndText else 0.dp
            )
        ) {
            WGText(
                text = infoPack.value.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            WGText(text = infoPack.title)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGInfoModule(
        InfoPack(
            imageId = R.drawable.completed,
            value = "0",
            title = "preview"
        )
    )
}