package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.common.domain.model.Player

@Composable
fun WGDelegateActivityPanel(
    input: List<Player>
//    isDataLoading: Boolean
) {
    WGCard {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                WGText(
                    text = "Temsilci Aktifliği",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                WGCombobox()
            }
            input.forEach { player ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    WGUserDetail(
                        player.photoUrl,
                        isDataLoading = false,
                        userName = player.name,
                        userDate = "26/12/2021 - 20:31",
                        isOnline = false
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    WGUserStatus(isOnline = false, {})
                }
                WGDotDivider()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGDelegateActivityPanel(
        listOf(
            Player(),
            Player(),
            Player(),
            Player(),
        )
    )
}