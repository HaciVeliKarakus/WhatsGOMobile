package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.data.PieChartInput
import io.bordo.whatsgomobile.ui.theme.YellowMain
import io.bordo.whatsgomobile.ui.theme.orange

@Composable
fun WGTerminationStatisticPanel() {
    WGCard {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            WGText(
                text = "Sonlandırma İstatistikleri",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            PieChart(
                modifier = Modifier
                    .size(400.dp),
                input = listOf(
                    PieChartInput(
                        color = YellowMain,
                        value = 29,
                        description = "Mutlu"
                    ),
                    PieChartInput(
                        color = orange,
                        value = 21,
                        description = "Mutsuz"
                    )
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGTerminationStatisticPanel()
}