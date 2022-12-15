package io.bordo.whatsgomobile.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import io.bordo.whatsgomobile.ui.navigation.RootNavigationGraph
import io.bordo.whatsgomobile.ui.theme.FantasyPremierLeagueTheme
import io.bordo.whatsgomobile.ui.viewmodel.player.PlayerViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    val viewModel: PlayerViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FantasyPremierLeagueTheme {
                RootNavigationGraph(viewModel)
            }
        }
    }
}



