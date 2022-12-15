package io.bordo.whatsgomobile.ui.screen.dashboard.product

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import io.bordo.common.domain.model.Player
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.screen.dashboard.shopping.ShoppingTopSection
import io.bordo.whatsgomobile.ui.theme.primaryColor
import io.bordo.whatsgomobile.ui.viewmodel.player.PlayerViewModel
import org.koin.androidx.compose.koinViewModel


//private val productService by lazy {
//    ProductService.create()
//}


@Composable
fun ProductScreen(
    viewModel: PlayerViewModel = koinViewModel()
) {
    val playerList = viewModel.state.value
//    val leagueName by viewModel.playerList.collectAsState("")

//    val leagues by viewModel.leagues.collectAsState(emptyList())
//
//    val isRefreshing by viewModel.isRefreshing.collectAsState()
//
//    LaunchedEffect(leagues) {
//        if (leagues.isNotEmpty()) {
//            viewModel.getLeagueStandings()
//        }
//    }

    Scaffold(
        topBar = {
            ShoppingTopSection()
//            TopAppBar(title = { Text("Product") })
        }) {
//        SwipeRefresh(
//            state = rememberSwipeRefreshState(isRefreshing),
//            onRefresh = { viewModel.getLeagueStandings() },
//        ) {
        LazyColumn {
            item {
                Chips(playerList.playerList)
            }
            items(items = playerList.playerList) { player ->
                ProductContentSection(player)
            }
        }
    }
}
//    Column {
//        ProductTopSection()
////        Chips()
//        Text(
//            modifier = Modifier.padding(start = 4.dp),
//            text = "Tavuk döner",
//            fontWeight = FontWeight.Bold
//        )
////        val products = produceState<List<ProductResponse>>(
////            initialValue = emptyList(),
////            producer = {
////                value = productService.getProducts()
////            }
////        )
//        ProductContentSection()
//}


@Composable
fun ProductContentSection(
    player: Player
) {

    Row(
        modifier = Modifier.padding(top = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = player.photoUrl,
            modifier = Modifier
                .width(100.dp)
                .height(50.dp),
            contentDescription = player.name
        )
        Column(modifier = Modifier.weight(5f)) {
            Text(
                text = player.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Surface(
                color = Color.Transparent,
                shape = CircleShape,
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.LightGray
                )
            ) {
                Text(
                    text = "₺${player.id * 13},00",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(

        ) {
            Row {
                Switch2()
                Icon(
                    modifier = Modifier
                        .height(15.dp)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = player.name
                )
            }
        }
    }

}


//@Preview
//@Composable
//fun PreviewActionMenu() {
//    val items = listOf(
//        ActionItemSpec("Call", Icons.Default.Call, ActionItemMode.ALWAYS_SHOW) {},
//        ActionItemSpec("Send", Icons.Default.Send, ActionItemMode.IF_ROOM) {},
//        ActionItemSpec("Email", Icons.Default.Email, ActionItemMode.IF_ROOM) {},
//        ActionItemSpec("Delete", Icons.Default.Delete, ActionItemMode.IF_ROOM) {},
//    )
//    TopAppBar(
//        title = { Text("App bar") },
//        navigationIcon = {
//            IconButton(onClick = {}) {
//                Icon(Icons.Default.Menu, "Menu")
//            }
//        },
//        actions = {
//            // show 3 icons including overflow
//            ActionMenu(items, defaultIconSpace = 3)
//        }
//    )
//}

@Preview
@Composable
fun Switch2(
    scale: Float = 1f,
    width: Dp = 36.dp,
    height: Dp = 20.dp,
    strokeWidth: Dp = 2.dp,
    checkedTrackColor: Color = primaryColor,
    uncheckedTrackColor: Color = Color(color = 0xFF76859B),
    gapBetweenThumbAndTrackEdge: Dp = 4.dp
) {

    val switchON = remember { mutableStateOf(true) }

    val thumbRadius = (height / 2) - gapBetweenThumbAndTrackEdge

    val animatePosition = animateFloatAsState(
        targetValue = when {
            switchON.value -> with(LocalDensity.current) { (width - thumbRadius - gapBetweenThumbAndTrackEdge).toPx() }
            else -> with(LocalDensity.current) { (thumbRadius + gapBetweenThumbAndTrackEdge).toPx() }
        }
    )

    Canvas(
        modifier = Modifier
            .size(width = width, height = height)
            .scale(scale = scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        // This is called when the user taps on the canvas
                        switchON.value = !switchON.value
                    }
                )
            }
    ) {
        drawRoundRect(
            color = when {
                switchON.value -> checkedTrackColor
                else -> uncheckedTrackColor
            },
            cornerRadius = CornerRadius(x = 10.dp.toPx(), y = 10.dp.toPx()),
            style = Stroke(width = strokeWidth.toPx())
        )
        drawCircle(
            color = when {
                switchON.value -> checkedTrackColor
                else -> uncheckedTrackColor
            },
            radius = thumbRadius.toPx(),
            center = Offset(
                x = animatePosition.value,
                y = size.height / 2
            )
        )
    }

//    Spacer(modifier = Modifier.height(18.dp))

//    Text(text = if (switchON.value) "ON" else "OFF")
}

@Composable
fun ProductStatusSwitch() {

    // Fetching the Local Context
    val mContext = LocalContext.current

    Column(
//        Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ) {

        val mCheckedState = remember { mutableStateOf(false) }

        // Creating a Switch, when value changes,
        // it updates mCheckedState value
        Switch(
            checked = mCheckedState.value,
            onCheckedChange = {
                mCheckedState.value = it
            }
        )

        // Adding a Space of 100dp height
//        Spacer(modifier = Modifier.height(100.dp))
//
//        // Creating a Button to display mCheckedState
//        // value in a Toast when clicked
//        Button(
//            onClick = {
//                Toast.makeText(mContext, mCheckedState.value.toString(), Toast.LENGTH_SHORT).show()
//            },
//            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58)),
//        ) {
//            Text("Show Checked State", color = Color.White)
//        }
    }
}

@Composable
fun ProductTopSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Icon(
            painterResource(id = R.drawable.ic_nav_product),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(horizontal = 20.dp),
            tint = primaryColor
        )
        Text(
            text = "Ürünler",
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.align(Alignment.Center)
        )

        Icon(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 24.dp),
            imageVector = Icons.Default.Search,
            contentDescription = "notifications"
        )
    }
}


@Composable
fun Chips(data: List<Player>) {
    Column {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            data.forEachIndexed { index, filter ->
                if (index % 10 == 0)
                    CustomChip(
                        selected = true,
                        text = filter.name,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
            }
        }
    }
}

@Composable
fun CustomChip(
    selected: Boolean,
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = when {
            selected -> Color.White
            else -> Color.Transparent
        },
        contentColor = when {
            selected -> Color.Transparent
            else -> Color.LightGray
        },
        shape = CircleShape,
        border = BorderStroke(
            width = 1.dp,
            color = when {
                selected -> primaryColor
                else -> Color.LightGray
            }
        ),
        modifier = modifier
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = typography.body2,
            color = when {
                selected -> primaryColor
                else -> Color.LightGray
            },
            modifier = Modifier.padding(8.dp)
        )
    }
}
