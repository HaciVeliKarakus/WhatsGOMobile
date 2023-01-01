package io.bordo.whatsgomobile.ui.screen.dashboard.message.tabs.groups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import io.bordo.whatsgomobile.ui.viewmodel.player.PlayerViewModel
import io.bordo.whatsgomobile.ui.theme.primaryColor
import org.koin.androidx.compose.koinViewModel


@Composable
fun GroupMessageScreen() {
    val viewModel = koinViewModel<PlayerViewModel>()
//    val leagueStandings by viewModel.leagueStandings.collectAsState(emptyList())
//    val leagueName by viewModel.leagueName.collectAsState("")
    val playerList = viewModel.state.value
//    val leagues by viewModel.leagues.collectAsState(emptyList())
//
//    val isRefreshing by viewModel.isRefreshing.collectAsState()
//
//    LaunchedEffect(leagues) {
//        if (leagues.isNotEmpty()) {
//            viewModel.getLeagueStandings()
//        }
//    }


    LazyColumn {
        items(items = playerList.playerList) { user ->
            Row {
                Box(
                    modifier = Modifier.padding(2.dp)
                ) {
                    AsyncImage(
                        model = user.photoUrl,
                        contentDescription = user.name,

                        modifier = Modifier.size(50.dp),
                    )
                }
                Column(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Text(text = user.team)
                    Text(text = user.assists.toString(), fontSize = 10.sp)
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier
                        .height(50.dp)
                        .padding(end = 4.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = user.id.toString(), fontSize = 10.sp, color = Color.LightGray)
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(
                                color = primaryColor,
                                shape = CircleShape
                            )
                            .layout { measurable, constraints ->
                                // Measure the composable
                                val placeable = measurable.measure(constraints)

                                //get the current max dimension to assign width=height
                                val currentHeight = placeable.height
                                val currentWidth = placeable.width
                                val newDiameter = maxOf(currentHeight, currentWidth)

                                //assign the dimension and the center position
                                layout(newDiameter, newDiameter) {
                                    // Where the composable gets placed
                                    placeable.placeRelative(
                                        (newDiameter - currentWidth) / 2,
                                        (newDiameter - currentHeight) / 2
                                    )
                                }
                            }
                    ) {
                        Text(
                            text = user.id.toString(),
                            fontSize = 10.sp,
                            color = Color.White,
                            modifier = Modifier.padding(1.dp)
                        )
                    }

                }
            }
            Divider(modifier = Modifier.padding(vertical = 2.dp))
        }
    }
}
