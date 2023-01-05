package io.bordo.whatsgomobile.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.bordo.whatsgomobile.data.SaleReportPanelModel

@Composable
fun WGSaleReportPanel(
    saleReportPanelModel: SaleReportPanelModel
) {
    WGCard {
        WGInfoModule(
            title = "Toplam Satış Tutarı",
            value = saleReportPanelModel.totalSalesAmount
        )
        WGDotDivider()
        WGInfoModule(
            title = "Toplam Sipariş",
            value = saleReportPanelModel.totalOrder
        )
        WGDotDivider()
        WGInfoModule(
            title = "Ortalama Sipariş Tutarı",
            value = saleReportPanelModel.averageOrderAmount
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGSaleReportPanel(
        saleReportPanelModel = SaleReportPanelModel()
    )
}