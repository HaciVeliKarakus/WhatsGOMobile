package io.bordo.whatsgomobile.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.viewmodel.player.PlayerViewModel
import io.bordo.whatsgomobile.ui.screen.dashboard.home.DashboardHomeScreen
import io.bordo.whatsgomobile.ui.screen.dashboard.message.DashboardMessageScreen
import io.bordo.whatsgomobile.ui.screen.dashboard.message.tabs.ChatScreen
import io.bordo.whatsgomobile.ui.screen.dashboard.product.ProductScreen
import io.bordo.whatsgomobile.ui.screen.dashboard.shopping.ShoppingScreen
import io.bordo.whatsgomobile.ui.ui.main.Screen


@Composable
fun DashboardNavGraph(
    navController: NavHostController,
    viewModel: PlayerViewModel
) {

    NavHost(
        navController = navController,
        route = WGGraph.DASHBOARD,
        startDestination = DashboardBottomBarScreen.Home.route
    ) {

        composable(route = DashboardBottomBarScreen.Home.route) {
            DashboardHomeScreen()
        }
        composable(route = DashboardBottomBarScreen.Message.route) {
            DashboardMessageScreen() { playerID ->
                navController.navigate(route = Screen.MessageDetailScreen.route + "/$playerID")
            }
        }
        composable(route = DashboardBottomBarScreen.Product.route) {
            ProductScreen()
        }
        composable(route = DashboardBottomBarScreen.ShoppingCart.route) {
            ShoppingScreen()
        }
        message(navController,viewModel)
    }
}


fun NavGraphBuilder.message(
    navController: NavHostController,
    viewModel: PlayerViewModel,
) {

    composable(
        Screen.MessageDetailScreen.route + "/{playerID}",
        arguments = listOf(navArgument("playerID") { type = NavType.IntType })
    ) { navBackStackEntry ->
        val playerId: Int? = navBackStackEntry.arguments?.getInt("playerID")
        playerId?.let {
            val player = viewModel.getPlayer(playerId)
            player?.let {
                ChatScreen(player) { navController.popBackStack() }
            }
        }
    }
}

sealed class DashboardBottomBarScreen(
    val route: String,
    val icon: Int
) {
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

sealed class MessageTopBarScreen(
    val route: String
) {
    object Waiting : MessageTopBarScreen(
        route = "waiting_message"
    )

    object New : MessageTopBarScreen(
        route = "new_message"
    )

    object Active : MessageTopBarScreen(
        route = "active_message"
    )

    object Group : MessageTopBarScreen(
        route = "groups_message"
    )
}
