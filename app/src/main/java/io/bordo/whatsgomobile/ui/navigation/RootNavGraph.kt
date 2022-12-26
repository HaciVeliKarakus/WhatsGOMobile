package io.bordo.whatsgomobile.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.bordo.whatsgomobile.ui.screen.dashboard.MainScreen


@Composable
fun RootNavigationGraph() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        route = WGGraph.ROOT,
        startDestination = WGGraph.AUTHENTICATION
    ) {
        authNavGraph(navController = navController)
        composable(route = WGGraph.DASHBOARD) {
            MainScreen()
        }
    }
}
