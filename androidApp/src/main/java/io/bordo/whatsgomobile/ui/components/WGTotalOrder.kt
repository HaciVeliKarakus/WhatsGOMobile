package io.bordo.whatsgomobile.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun WGTotalOrder() {
    WGCard {
        WGText(
            text = "Toplam Sipariş",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        WGLineChart()
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGTotalOrder()
}