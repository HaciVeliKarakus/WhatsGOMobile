package io.bordo.whatsgomobile.ui.screen.dashboard.message

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.pager.*
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.navigation.MessageTopBarScreen
import io.bordo.whatsgomobile.ui.screen.dashboard.message.tabs.newmessage.NewMessageScreen
import io.bordo.whatsgomobile.ui.screen.dashboard.message.tabs.active.ActiveMessageScreen
import io.bordo.whatsgomobile.ui.screen.dashboard.message.tabs.groups.GroupMessageScreen
import io.bordo.whatsgomobile.ui.screen.dashboard.message.tabs.waiting.WaitingMessageScreen
import io.bordo.whatsgomobile.ui.theme.primaryColor

import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun DashboardMessageScreen(
    onMessageSelected: (messageId: Int) -> Unit
) {
    val pagerState = rememberPagerState()
    Column {
        MessageTopSection()
        Tabs(pagerState = pagerState)
        TabsContent(
            pagerState = pagerState,
            onMessageSelected = onMessageSelected
        )
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(
    pagerState: PagerState,
    onMessageSelected: (messageId: Int) -> Unit
) {
    HorizontalPager(count = 4, state = pagerState) { page ->
        when (page) {
            0 -> WaitingMessageScreen(onMessageSelected)
            1 -> NewMessageScreen()
            2 -> ActiveMessageScreen()
            3 -> GroupMessageScreen()
        }
    }
}

@Composable
fun TabContentScreen(data: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = data,
            style = MaterialTheme.typography.h5,
            color = Color.Green,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(pagerState: PagerState) {

    val list = listOf(
        "Bekleyen" to Icons.Default.Home,
        "Yeni" to Icons.Default.ShoppingCart,
        "Aktif" to Icons.Default.Settings,
        "Gruplar" to Icons.Default.Warning
    )

    val scope = rememberCoroutineScope()
    TabRow(selectedTabIndex = pagerState.currentPage,
//        contentColor = Color.White,
        backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 3.dp,
                color = primaryColor
            )
        }) {
        list.forEachIndexed { index, _ ->
            Tab(
                modifier = Modifier.height(80.dp), icon = {
                    val borderSize = 35.dp
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = tabCircleController(pagerState, index, borderSize)
                    ) {
                        Text(
                            fontSize = 12.sp,
                            text = "1",
                            color = textColorController(pagerState, index),
                            textAlign = TextAlign.Center,
                        )
                    }
                }, text = {
                    Text(
                        list[index].first,
                        color = textColorController(pagerState, index),
                        fontSize = 10.sp

                    )
                }, selected = pagerState.currentPage == index, onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun tabCircleController(
    pagerState: PagerState,
    index: Int, borderSize: Dp
) = if (pagerState.currentPage == index) Modifier
    .clip(shape = CircleShape)
    .size(borderSize)
    .border(1.dp, color = primaryColor, shape = CircleShape)
    .background(Color.Transparent)
else Modifier
    .clip(shape = CircleShape)
    .size(borderSize)
    .background(Color.LightGray)

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun textColorController(
    pagerState: PagerState,
    index: Int
) = if (pagerState.currentPage == index) primaryColor else Color.Black


@Composable
fun MessageTopSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Icon(
            painterResource(id = R.drawable.ic_nav_message),
            contentDescription = "home-logo",
            tint = primaryColor,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(horizontal = 20.dp),
        )
        Text(
            text = "Mesajlar",
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


@Composable
fun TopBar() {
    TopAppBar(title = { Text(text = "Messajlar") })
}

@Composable
fun MessageTopNavigation(
    navController: NavHostController
) {
    val screens = listOf(
        MessageTopBarScreen.Waiting,
        MessageTopBarScreen.New,
        MessageTopBarScreen.Active,
        MessageTopBarScreen.Group,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation {
        screens.forEach { screen ->
            AddTopBarItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddTopBarItem(
    screen: MessageTopBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(icon = {},
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        label = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedButton(
                    onClick = {

                    }, modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(60.dp)
//                        .border(
//                            1.dp,
//                            color = primaryColor,
//                            shape = CircleShape
//                        )
//
//                        .background(
//                            if (text == selectedOption) Color.Transparent else Color.LightGray
//                        ),

                ) {
                    Text(
                        fontSize = 12.sp,
                        text = screen.route,
//                        color = if (text == selectedOption) primaryColor else Color.Black,
                        textAlign = TextAlign.Center,
                    )
                }
                Text(
                    text = "1",
//                    color = if (text == selectedOption) primaryColor else Color.Black
                )
            }

        },
        selectedContentColor = primaryColor,
        unselectedContentColor = Color.LightGray,
        onClick = {
            navController.navigate(screen.route)
        })
}

@Composable
fun MessagePart() {

    Column {
//        waiting_message.forEachIndexed { index, customer ->
//
//            Row {
//                Box {
//                    Image(
//                        painterResource(id = R.drawable.emrah),
//                        contentDescription = null,
//
//                        modifier = Modifier.size(50.dp),
//                    )
//                    Box(
//                        modifier = Modifier
//                            .width(10.dp)
//                            .aspectRatio(1f)
//                            .background(Color.White, shape = CircleShape)
//                            .align(Alignment.BottomEnd), contentAlignment = Alignment.Center
//                    ) {
//                        Box(
//                            modifier = Modifier
//                                .padding(1.dp)
//                                .width(5.dp)
//                                .aspectRatio(1f)
//                                .background(
//                                    color = if (customer.source == Source.WHATSAPP) Color.Green else Color.Blue,
//                                    shape = CircleShape
//                                ),
//                        )
//                    }
//                }
//                Spacer(modifier = Modifier.weight(1f))
//                Text(text = customer.type)
//            }
//        }
    }
}
