package io.bordo.whatsgomobile.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import io.bordo.common.domain.model.Player


@Composable
fun WGDelegateStatistic(
    input: List<Player>
) {
    WGCard {
        WGText(
            text = "Temsilci İstatistikleri",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        WGSpacer()
        input.forEach { player ->
            WGSpacer()
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    WGText(
                        text = player.name
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    WGLinearProgressIndicator(progress = player.assists.toFloat())

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGDelegateStatistic(listOf(Player()))
}