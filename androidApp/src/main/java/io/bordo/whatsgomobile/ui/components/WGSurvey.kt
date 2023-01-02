package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.ui.theme.BarPink


@Composable
fun WGSurvey(
    text: String,
    value: Int
) {
    Box(
        modifier = Modifier
            .height(28.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))

    ) {
        Box(
            modifier = Modifier
                .background(BarPink)
                .fillMaxHeight()
                .fillMaxWidth(value.toFloat() / 100)
                .clip(RoundedCornerShape(10.dp))

        )
        Text(
            text = text,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterStart),
            color = Color.White

        )
        Text(
            text = "%$value",
            modifier = Modifier
                .align(Alignment.CenterEnd)
//                .padding(end = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview(){
    WGSurvey(text = "preview", value = 5)
}