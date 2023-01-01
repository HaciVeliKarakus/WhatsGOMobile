package io.bordo.whatsgomobile.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.bordo.whatsgomobile.ui.screen.dashboard.DashboardScreen


@Composable
fun RootNavigationGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        route = WGGraph.ROOT,
        startDestination = WGGraph.AUTHENTICATION
    ) {

        loginNavGraph(navController = navController)

        composable(route = WGGraph.DASHBOARD) {
            DashboardScreen()
        }
    }
}
