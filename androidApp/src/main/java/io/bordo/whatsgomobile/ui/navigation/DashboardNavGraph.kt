package io.bordo.whatsgomobile.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.screen.dashboard.home.HomeScreen
import io.bordo.whatsgomobile.ui.screen.dashboard.message.MessageScreen
import io.bordo.whatsgomobile.ui.screen.dashboard.message.tabs.ChatScreen
import io.bordo.whatsgomobile.ui.screen.dashboard.product.ProductScreen
import io.bordo.whatsgomobile.ui.screen.dashboard.shopping.ShoppingScreen
import io.bordo.whatsgomobile.ui.viewmodel.player.PlayerViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun DashboardNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = WGGraph.DASHBOARD,
        startDestination = DashboardBottomBarScreen.Home.route
    ) {

        composable(route = DashboardBottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = DashboardBottomBarScreen.Message.route) {
            MessageScreen() { playerID ->
                navController.navigate(route = Screen.MessageDetailScreen.route + "/$playerID")
            }
        }
        composable(route = DashboardBottomBarScreen.Product.route) {
            ProductScreen()
        }
        composable(route = DashboardBottomBarScreen.ShoppingCart.route) {
            ShoppingScreen()
        }

        composable(
            route = Screen.MessageDetailScreen.route + "/{playerID}",
            arguments = listOf(navArgument("playerID") { type = NavType.IntType })
        ) { navBackStackEntry ->
            val viewModel = koinViewModel<PlayerViewModel>()
            val playerId: Int? = navBackStackEntry.arguments?.getInt("playerID")
            playerId?.let {
                val player = viewModel.getPlayer(playerId)
                player?.let {
                    ChatScreen(player) { navController.popBackStack() }
                }
            }
        }
    }
}


sealed class DashboardBottomBarScreen(val route: String, val icon: Int) {

    object Home : DashboardBottomBarScreen(
        route = "home",
        icon = R.drawable.ic_nav_home
    )

    object Message : DashboardBottomBarScreen(
        route = "message",
        icon = R.drawable.ic_nav_message
    )

    object Product : DashboardBottomBarScreen(
        route = "product",
        icon = R.drawable.ic_nav_product
    )

    object ShoppingCart : DashboardBottomBarScreen(
        route = "cart",
        icon = R.drawable.ic_nav_shopping_cart
    )
}

sealed class MessageTopBarScreen(val route: String) {

    object WaitingMessageScreen : MessageTopBarScreen(route = "waiting_message")
    object NewMessageScreen : MessageTopBarScreen(route = "new_message")
    object ActiveMessageScreen : MessageTopBarScreen(route = "active_message")
    object GroupMessageScreen : MessageTopBarScreen(route = "groups_message")
}
