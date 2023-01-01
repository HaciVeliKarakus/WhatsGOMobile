package io.bordo.whatsgomobile.ui.screen.dashboard.message.tabs.newmessage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.accompanist.placeholder.placeholder
import io.bordo.common.domain.model.Player
import io.bordo.whatsgomobile.ui.viewmodel.player.PlayerViewModel
import io.bordo.whatsgomobile.ui.theme.BtnGreenLight
import io.bordo.whatsgomobile.ui.theme.lowfidelitygray
import io.bordo.whatsgomobile.ui.theme.primaryColor
import org.koin.androidx.compose.koinViewModel


@Composable
fun NewMessageScreen() {
    val viewModel = koinViewModel<PlayerViewModel>()
    val playerList = viewModel.state.value
    val isDataLoading = playerList.playerList.isEmpty()

    LazyColumn {
        items(items = playerList.playerList) { user ->
            newMessageView(user, isDataLoading)
        }
    }
}

@Composable
private fun newMessageView(
    user: Player,
    isDataLoading: Boolean
) {
    Row {
        leftSection(user, isDataLoading)
        centerSection(user)
        Spacer(modifier = Modifier.weight(weight = 1f))
        rightSection(user)
    }
}

@Composable
private fun leftSection(
    user: Player,
    isDataLoading: Boolean
) {
    Box(
        modifier = Modifier
            .padding(2.dp)
    ) {
        AsyncImage(
            model = user.photoUrl,
            contentDescription = user.name,
            modifier = Modifier
                .size(50.dp)
                .placeholder(
                    visible = isDataLoading,
                    color = lowfidelitygray
                )
        )
        Box(
            modifier = Modifier
                .width(15.dp)
                .aspectRatio(1f)
                .background(Color.White, shape = CircleShape)
                .align(Alignment.BottomEnd), contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = user.photoUrl,
                contentDescription = user.name,
                modifier = Modifier.padding(2.dp),
            )
        }
    }
}

@Composable
private fun centerSection(user: Player) {
    Column(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(text = user.name)
        Text(
            text = user.assists.toString(),
            fontSize = 10.sp
        )
    }
}

@Composable
private fun rightSection(user: Player) {
    Column(
        modifier = Modifier
            .height(50.dp)
            .padding(end = 4.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = user.points.toString(),
            fontSize = 10.sp,
            color = Color.LightGray
        )
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
                text = user.points.toString(),
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier.padding(1.dp)
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(
                    color = BtnGreenLight,
                    shape = CircleShape
                )
        ) {
            Text(
                text = user.team,
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(horizontal = 3.dp)
            )
        }
    }
}
