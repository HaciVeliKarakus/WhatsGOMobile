package io.bordo.whatsgomobile.ui.screen.dashboard.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.common.domain.model.Player
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.data.InfoPack
import io.bordo.whatsgomobile.ui.components.*
import io.bordo.whatsgomobile.ui.theme.PurpleMain


@Composable
fun HomeScreen() {

    Scaffold(
        topBar = { TopSection() }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                WGMessagePanel(
                    waitingMessageInfo = InfoPack(),
                    activeMessageInfo = InfoPack(),
                    newMessageInfo = InfoPack(),
                    doneMessageInfo = InfoPack()
                )
            }
            item {
                WGSaleReportPanel(
                    InfoPack(),
                    InfoPack(),
                    InfoPack()
                )
            }
            item {
                OrderSection()
            }
            item {
                TotalOrderSection()
            }
            item {
                GraphSection()
            }
            item {
                Row {
                    Text(
                        text = "Temsilci Aktifli??i",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Light
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    WGCombobox()
                }
//                TextField(
//                    singleLine = true,
//                    values="",
////                    value = playerSearchQuery.value,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp),
////                        .placeholder(
////                            visible = tr,
////                            color = lowfidelitygray
////                        ),
//                    label = {
//                        Text(text = "Search")
//                    },
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Default.Search,
//                            contentDescription = "Search"
//                        )
//                    },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Text,
//                        imeAction = ImeAction.Search
//                    ),
//                    onValueChange = {
////                        viewModel.onPlayerSearchQueryChange(it)
//                    }
//                )
                Divider()

            }

//            DelegateStatisticSection()

//            if (isDataLoading) {
//                items(
//                    items = placeHolderPlayerList, itemContent = { player ->
//                        DelegateSection(player, isDataLoading)
//                    })
//            } else {
//            items(items = playerList.value, itemContent = { player ->
//                DelegateSection(player, isDataLoading)
//            })
//            }
            item {
                SurveySection()
            }
        }
    }
}

@Composable
private fun TopSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(64.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        WGIcon(
            id = R.drawable.ic_nav_home,
            tint = PurpleMain
        )
        WGSpacer(width = 8.dp, height = 0.dp)
        WGText(
            text = "WhatsGO Call Center",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
        WGIcon(
            id = R.drawable.ic_notification
        )
    }
}


//@Preview
@Composable
private fun OrderSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column {
                Text(
                    text = "Mesajlar",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                )
                Row(modifier = Modifier.padding(10.dp)) {
                    Image(painterResource(id = R.drawable.order_waiting), contentDescription = null)
                    Text(
                        text = "0", modifier = Modifier
                            .width(33.dp)
                            .padding(5.dp)
                    )
                    Text(
                        text = "Beklemede", modifier = Modifier.padding(5.dp)
                    )
                }
                Divider()
                Row(modifier = Modifier.padding(10.dp)) {
                    Image(painterResource(id = R.drawable.order_reading), contentDescription = null)
                    Text(
                        text = "37", modifier = Modifier
                            .width(33.dp)
                            .padding(5.dp)
                    )
                    Text(text = "Haz??rlan??yor", modifier = Modifier.padding(5.dp))
                }
                Divider()
                Row(modifier = Modifier.padding(10.dp)) {
                    Image(painterResource(id = R.drawable.order_sending), contentDescription = null)
                    Text(
                        text = "8", modifier = Modifier
                            .width(33.dp)
                            .padding(5.dp)
                    )
                    Text(text = "G??nderimde", modifier = Modifier.padding(5.dp))
                }
//                Divider()
//                Row(modifier = Modifier.padding(10.dp)) {
//                    Image(painterResource(id = R.drawable.order_sending), contentDescription = null)
//                    Text(
//                        text = "8", modifier = Modifier
//                            .width(33.dp)
//                            .padding(5.dp)
//                    )
//                    Text(text = "G??nderimde", modifier = Modifier.padding(5.dp))
//                }
                Divider()
                Row(modifier = Modifier.padding(10.dp)) {
                    Image(
                        painterResource(id = R.drawable.order_canceled), contentDescription = null
                    )
                    Text(
                        text = "4", modifier = Modifier
                            .width(33.dp)
                            .padding(5.dp)
                    )
                    Text(text = "??ptal Edildi", modifier = Modifier.padding(5.dp))
                }
                Divider()
                Row(modifier = Modifier.padding(10.dp)) {
                    Image(painterResource(id = R.drawable.order_sending), contentDescription = null)
                    Text(
                        text = "8", modifier = Modifier
                            .width(33.dp)
                            .padding(5.dp)
                    )
                    Text(text = "Teslim Edildi", modifier = Modifier.padding(5.dp))
                }
            }
        }
    }
}


@Composable
private fun TotalOrderSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(10.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "Toplam Sipari??",
                fontSize = 15.sp,
                fontWeight = FontWeight.Light
            )
            Image(
                painterResource(id = R.drawable.graph),
                contentDescription = null,
                modifier = Modifier
                    .width(500.dp)
                    .height(400.dp)
            )
        }
    }
}


@Composable
private fun DelegateSection(
    player: Player,
    isDataLoading: Boolean
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row {
                WGUserDetail(
                    player.photoUrl,
                    isDataLoading = isDataLoading,
                    userName = player.name,
                    userDate = "26/12/2021 - 20:31",
                    isOnline = false
                )

                Spacer(modifier = Modifier.weight(1f))

                WGUserStatus(isOnline = false, {})
            }
            Divider()
        }
    }
}

@Composable
fun GraphSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(10.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            Text(
                text = "Sonland??rma ??statistikleri",
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Column {
                Image(
                    painterResource(id = R.drawable.donut_chart),
                    contentDescription = null,
                    modifier = Modifier.size(300.dp),
                )
                Image(
                    painterResource(id = R.drawable.donut_chart_legend),
                    contentDescription = null,
                    modifier = Modifier
                        .width(300.dp)
                        .height(20.dp)
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun DelegateStatisticSection() {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp),
//        elevation = 1.dp,
//        shape = RoundedCornerShape(10.dp)
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(10.dp),
//        ) {
//            Text(
//                text = "Temsilci ??statistikleri",
//                modifier = Modifier.padding(vertical = 10.dp)
//            )
//            Column(
//                modifier = Modifier
//                    .padding(10.dp)
//                    .fillMaxWidth()
//            ) {
//
//                data.forEach { delegate ->
//                    DelegateStatisticWidget(name = delegate.name, progress = delegate.progress)
//                }
//            }
//        }
//    }
//}

@Composable
fun SurveySection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            Text(
                text = "Anket",
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Text(text = "Aut inventore cum libero labore delectus voluptas hic aspernatur. Impedit facere explicabo eligendi deleniti sit?")

            Spacer(modifier = Modifier.height(10.dp))

            WGSurvey(text = "Evet", value = 17)
            Spacer(modifier = Modifier.height(10.dp))

            WGSurvey(text = "Hay??r", value = 79)
            Spacer(modifier = Modifier.height(10.dp))

            WGSurvey(text = "Karars??z", value = 44)
        }
    }
}


fun Modifier.asd(): Modifier = clip(CircleShape).background(Color.Red)

@Preview
@Composable
private fun Preview() {
    HomeScreen()
}