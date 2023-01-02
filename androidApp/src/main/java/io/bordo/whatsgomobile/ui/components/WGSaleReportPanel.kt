package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.data.InfoPack

@Composable
fun WGSaleReportPanel(
    totalSalesAmount: InfoPack,
    totalOrder: InfoPack,
    averageOrderAmount: InfoPack
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(size = 12.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
        ) {
            item {
                WGInfoModule(infoPack = totalSalesAmount)

            }
            item {
                WGSpacer(height = 8.dp)
                WGDivider(type = DividerType.Dot, horizontalPadding = 20.dp)
                WGSpacer(height = 8.dp)
            }
            item {
                WGInfoModule(infoPack = totalOrder)
            }
            item {
                WGSpacer(height = 8.dp)
                WGDivider(type = DividerType.Dot, horizontalPadding = 20.dp)
                WGSpacer(height = 8.dp)
            }
            item {
                WGInfoModule(infoPack = averageOrderAmount)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGSaleReportPanel(
        totalSalesAmount = InfoPack(
            value = "₺2.904,00",
            title = "Toplam Satış Tutarı"
        ),
        totalOrder = InfoPack(
            value = "138",
            title = "Toplam Sipariş"
        ),
        averageOrderAmount = InfoPack(
            value = "₺191,48",
            title = "Ortalama Sipariş Tutarı"
        )
    )
}