package io.bordo.whatsgomobile.ui.screen.dashboard.message.tabs.active


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.bordo.common.domain.model.Player
import io.bordo.whatsgomobile.data.MessageRowModel
import io.bordo.whatsgomobile.ui.components.WGDotDivider
import io.bordo.whatsgomobile.ui.components.WGMessageRow
import io.bordo.whatsgomobile.ui.components.WGSpacer
import io.bordo.whatsgomobile.ui.viewmodel.player.PlayerViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ActiveMessageScreen() {
    val viewModel = koinViewModel<PlayerViewModel>()
    val userList = viewModel.state.value.playerList

    Screen(userList)
}

@Composable
private fun Screen(userList: List<Player>) {
    LazyColumn {
        item { WGSpacer() }
        itemsIndexed(items = userList) { index, user ->
            WGMessageRow(
                MessageRowModel(
                    imageUrl = user.photoUrl,
                    userName = user.name
                ),
                horizontalSpace=16.dp
            )
            if (index+1 < userList.size) {
                WGDotDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Screen(
        userList = listOf(
            Player(),
            Player(),
        )
    )
}
