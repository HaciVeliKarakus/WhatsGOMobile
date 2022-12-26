package io.bordo.whatsgomobile.ui.screen.dashboard.shopping

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import io.bordo.common.domain.model.Player
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.components.VerticalDivider
import io.bordo.whatsgomobile.ui.theme.primaryColor
import io.bordo.whatsgomobile.ui.viewmodel.player.PlayerViewModel
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun ShoppingScreen() {
    val viewModel: PlayerViewModel = koinViewModel()
    val playerList = viewModel.state.value.playerList
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        LazyColumn {
            item {
                ShoppingTopSection()
            }
            item {
                TotalMonitorSection()
            }
            items(items = playerList) { player ->
                ContentListSection(player)
            }
        }
    }
}

@Composable
fun ContentListSection(player: Player) {
    Row(
        modifier = Modifier.padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = player.name,
            fontSize = 10.sp,
            modifier = Modifier.width(100.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = player.photoUrl,
                contentDescription = player.name,
                modifier = Modifier.size(40.dp)
            )
            Icon(
                Icons.Default.ArrowDropDown,
                contentDescription = player.name,
//                    modifier = Modifier.align(Alignment.CenterVertically),
            )
        }
        Box(modifier = Modifier.weight(1f)) {
            Text(
                text = player.currentPrice.toString(),
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Text(
                text = player.name,
                color = LightGray,
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.Center)
            )
            Icon(
                Icons.Default.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
    Divider()
}


@Composable
fun TotalMonitorSection() {
    Row {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "123", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Sipariş")
        }
        VerticalDivider()
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "98", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Müşteri")
        }
        VerticalDivider()
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "145", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Ürün")
        }
    }

}

@Composable
fun ShoppingTopSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Icon(
            painterResource(id = R.drawable.ic_nav_shopping_cart),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(horizontal = 20.dp),
            tint = primaryColor
        )
        Text(
            text = "Siparişler",
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.align(Alignment.Center)
        )

        Icon(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 58.dp),
            imageVector = Icons.Default.Search,
            contentDescription = "notifications"
        )
        Icon(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 24.dp),
            imageVector = Icons.Default.LocationOn,
            contentDescription = null
        )
    }
}

