package io.bordo.whatsgomobile.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.bordo.whatsgomobile.ui.viewmodel.player.PlayerViewModel
import io.bordo.whatsgomobile.ui.screen.dashboard.MainScreen


@Composable
fun RootNavigationGraph(
    viewModel: PlayerViewModel
) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        route = WGGraph.ROOT,
        startDestination = WGGraph.AUTHENTICATION
    ) {
        authNavGraph(navController = navController)
        composable(route = WGGraph.DASHBOARD) {
            MainScreen(viewModel)
        }
    }
}

object WGGraph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val DASHBOARD = "dashboard_graph"
    const val MESSAGE = "message_graph"

}
