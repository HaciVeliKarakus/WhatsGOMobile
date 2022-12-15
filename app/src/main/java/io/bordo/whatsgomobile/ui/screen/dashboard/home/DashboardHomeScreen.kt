package io.bordo.whatsgomobile.ui.screen.dashboard.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.common.domain.model.Player
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.components.*


@Composable
fun DashboardHomeScreen() {

    Scaffold(
        topBar = { TopSection() }
    ) {


        LazyColumn {
            item {
                MessageSection()
            }
            item {
                SaleReportSection()
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
                        text = "Temsilci Aktifliği",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Light
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    ComboboxWidget()
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


//@Preview
@Composable
fun TopSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "home-logo",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(horizontal = 20.dp)
        )
        Text(
            text = "WhatsGO Call Center",
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.align(Alignment.Center)
        )

        Icon(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 24.dp),
            imageVector = Icons.Default.Notifications,
            contentDescription = "notifications"
        )
    }
}

//@Preview
@Composable
fun MessageSection() {
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
                text = "Mesajlar",
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column {
                    Row {
                        Image(
                            painterResource(id = R.drawable.waiting), contentDescription = "waiting"
                        )
                        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                            Text(text = "2")
                            Text(text = "Bekleyen")
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Image(
                            painterResource(id = R.drawable.resource_new),
                            contentDescription = "waiting"
                        )
                        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                            Text(text = "8")
                            Text(text = "Yeni")
                        }
                    }
                }
                Column {
                    Row {
                        Image(
                            painterResource(id = R.drawable.active), contentDescription = "active"
                        )
                        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                            Text(text = "37")
                            Text(text = "Aktif")
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Image(
                            painterResource(id = R.drawable.completed),
                            contentDescription = "waiting"
                        )
                        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                            Text(text = "414")
                            Text(text = "Sonlanan")
                        }
                    }
                }
            }
        }
    }
}

//@Preview
@Composable
fun SaleReportSection() {
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
                Row(modifier = Modifier.padding(10.dp)) {
                    Column {
                        BigText(text = "₺2.904,00")
                        SmallText(text = "Toplam Satış Tutarı")
                    }
                }
                Divider()
                Row(modifier = Modifier.padding(10.dp)) {
                    Column {
                        BigText(text = "138")
                        SmallText(text = "Toplam Sipariş")
                    }
                }
                Divider()
                Row(modifier = Modifier.padding(10.dp)) {
                    Column {
                        BigText(text = "₺191,48")
                        SmallText(text = "Ortalama Sipariş Tutarı")
                    }
                }
            }
        }
    }
}

//@Preview
@Composable
fun OrderSection() {
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
                    Text(text = "Hazırlanıyor", modifier = Modifier.padding(5.dp))
                }
                Divider()
                Row(modifier = Modifier.padding(10.dp)) {
                    Image(painterResource(id = R.drawable.order_sending), contentDescription = null)
                    Text(
                        text = "8", modifier = Modifier
                            .width(33.dp)
                            .padding(5.dp)
                    )
                    Text(text = "Gönderimde", modifier = Modifier.padding(5.dp))
                }
//                Divider()
//                Row(modifier = Modifier.padding(10.dp)) {
//                    Image(painterResource(id = R.drawable.order_sending), contentDescription = null)
//                    Text(
//                        text = "8", modifier = Modifier
//                            .width(33.dp)
//                            .padding(5.dp)
//                    )
//                    Text(text = "Gönderimde", modifier = Modifier.padding(5.dp))
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
                    Text(text = "İptal Edildi", modifier = Modifier.padding(5.dp))
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
fun TotalOrderSection() {
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
                text = "Toplam Sipariş",
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
fun DelegateSection(
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
                UserDetailWidget(
                    player.photoUrl,
                    isDataLoading = isDataLoading,
                    userName = player.name,
                    userDate = "26/12/2021 - 20:31",
                    isOnline = false
                )

                Spacer(modifier = Modifier.weight(1f))

                UserStatusWidget(isOnline = false)
            }
            Divider()
        }
    }
}

@Preview
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
                text = "Sonlandırma İstatistikleri",
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
//                text = "Temsilci İstatistikleri",
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

@Preview(showSystemUi = true)
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

            SurveyWidget(text = "Evet", value = 17)
            Spacer(modifier = Modifier.height(10.dp))

            SurveyWidget(text = "Hayır", value = 79)
            Spacer(modifier = Modifier.height(10.dp))

            SurveyWidget(text = "Kararsız", value = 44)
        }
    }
}


fun Modifier.asd(): Modifier = clip(CircleShape).background(Color.Red)