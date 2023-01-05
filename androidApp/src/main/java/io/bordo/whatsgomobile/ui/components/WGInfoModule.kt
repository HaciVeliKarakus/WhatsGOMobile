package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.data.types.InfoModuleType

@Composable
fun WGInfoModule(
    imageId: Int? = null,
    value: String,
    title: String,
    type: InfoModuleType = InfoModuleType.Vertical,
    spaceBetweenImageAndText: Dp = 16.dp
) {
    var isNeedSpace = false

    Row(verticalAlignment = Alignment.CenterVertically) {

        imageId?.let {
            WGImage(id = it)
            isNeedSpace = !isNeedSpace
        }
        WGSpacer(width = if (isNeedSpace) spaceBetweenImageAndText else 0.dp)

        when (type) {
            InfoModuleType.Vertical -> Column(

            ) {
                WGText(
                    text = value,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                WGText(text = title)
            }
            InfoModuleType.Horizontal -> Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                WGText(
                    text = value,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                WGSpacer(width = 8.dp)
                WGText(text = title)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGInfoModule(
        imageId = R.drawable.completed,
        value = "42",
        title = "Preview",
        type = InfoModuleType.Horizontal
    )
}