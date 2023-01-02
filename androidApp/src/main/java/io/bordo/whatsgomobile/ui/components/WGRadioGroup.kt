package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.ui.theme.primaryColor

import kotlin.random.Random

@Composable
fun WGRadioGroup() {
    val options = listOf(
        "bekleyen",
        "yeni",
        "aktif",
        "grup"
    )
    val values = listOf(
        Random.nextInt(1, 100),
        Random.nextInt(1, 100),
        Random.nextInt(1, 100),
        Random.nextInt(1, 100),
    )
    val startValue = "Yeni"
    var selectedOption by remember { mutableStateOf(startValue) }
    val onSelectionChange = { text: String ->
        selectedOption = text
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            options.forEachIndexed { index, text ->
                Row(
                    modifier = Modifier
                        .padding(all = 8.dp),
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedButton(
                            onClick = {
                                onSelectionChange(text)
                            },
                            modifier = Modifier
                                .clip(shape = CircleShape)
                                .size(60.dp)
                                .border(
                                    1.dp,
                                    color = if (text == selectedOption) primaryColor else Color.LightGray,
                                    shape = CircleShape
                                )

                                .background(
                                    if (text == selectedOption) Color.Transparent else Color.LightGray
                                ),

                            ) {
                            Text(
                                fontSize = 12.sp,
                                text = values[index].toString(),
                                color = if (text == selectedOption) primaryColor else Color.Black,
                                textAlign = TextAlign.Center,
                            )
                        }
                        Text(
                            text = text,
                            color = if (text == selectedOption) primaryColor else Color.Black
                        )
                    }

//                if (index + 1 < options.size)
//                    VerticalDivider()
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGRadioGroup()
}
