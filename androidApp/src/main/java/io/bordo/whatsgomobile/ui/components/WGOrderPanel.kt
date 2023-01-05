package io.bordo.whatsgomobile.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.data.OrderPanelModel
import io.bordo.whatsgomobile.data.types.InfoModuleType

//@Preview
@Composable
fun WGOrderPanel(
    orderPanelModel: OrderPanelModel
) {
    WGCard {
        WGText(
            text = "Siparişler",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        WGSpacer()
        WGInfoModule(
            imageId = R.drawable.order_waiting,
            type = InfoModuleType.Horizontal,
            title = "Beklemede",
            value = orderPanelModel.pending
        )
        WGDotDivider()
        WGInfoModule(
            imageId = R.drawable.order_reading,
            type = InfoModuleType.Horizontal,
            title = "Hazırlanıyor",
            value = orderPanelModel.preparing
        )
        WGDotDivider()
        WGInfoModule(
            imageId = R.drawable.order_sending,
            type = InfoModuleType.Horizontal,
            title = "Gönderinde",
            value = orderPanelModel.submission
        )
        WGDotDivider()
        WGInfoModule(
            imageId = R.drawable.order_canceled,
            type = InfoModuleType.Horizontal,
            title = "İptal Edildi",
            value = orderPanelModel.cancelled
        )
        WGDotDivider()
        WGInfoModule(
            imageId = R.drawable.order_done,
            type = InfoModuleType.Horizontal,
            title = "Teslim edildi",
            value = orderPanelModel.cancelled
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGOrderPanel(
        OrderPanelModel()
    )
}