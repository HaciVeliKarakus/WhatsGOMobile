package io.bordo.whatsgomobile.ui.screen.dashboard.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.bordo.common.domain.model.Player
import io.bordo.whatsgomobile.data.MessagePanelModel
import io.bordo.whatsgomobile.data.OrderPanelModel
import io.bordo.whatsgomobile.data.SaleReportPanelModel
import io.bordo.whatsgomobile.ui.components.*
import io.bordo.whatsgomobile.ui.theme.WhiteMain


@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            WGTopSection(headerText = "WhatsGO Call Center")
        },
        backgroundColor = WhiteMain
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                WGMessagePanel(
                    messagePanelModel = MessagePanelModel()
                )
            }
            item {
                WGSaleReportPanel(
                    saleReportPanelModel = SaleReportPanelModel()
                )
            }
            item {
                WGOrderPanel(
                    orderPanelModel = OrderPanelModel()
                )
            }
            item {
                WGTotalOrder()
            }
            item {
                WGDelegateActivityPanel(
                    listOf(
                        Player(),
                        Player(),
                        Player(),
                        Player(),
                    )
                )
            }
            item {
                WGTerminationStatisticPanel()
            }
            item {
                WGDelegateStatistic(
                    listOf(
                        Player(name = "Furkan Ateş"),
                        Player(name = "Emrah Yaman"),
                        Player(name = "Devrim Yılmaz"),
                        Player(name = "Ekin Akbayrak"),
                    )
                )
            }
            item {
                WGSurveyPanel()
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    HomeScreen()
}