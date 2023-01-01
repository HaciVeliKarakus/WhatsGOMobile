package io.bordo.whatsgomobile.ui.screen.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.bordo.whatsgomobile.ui.navigation.DashboardBottomBarScreen
import io.bordo.whatsgomobile.ui.navigation.DashboardNavGraph


@Composable
fun DashboardScreen() {
    val navController = rememberNavController()

    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    
    val screens = listOf(
        DashboardBottomBarScreen.Home,
        DashboardBottomBarScreen.Message,
        DashboardBottomBarScreen.Product,
        DashboardBottomBarScreen.ShoppingCart,
    )

    showBottomBar = navBackStackEntry?.destination?.route in screens.map { it.route }

    Scaffold(
        bottomBar = { if (showBottomBar) BottomBar(navController = navController) }
    ) {
        Box(modifier = Modifier.padding(it)) {
            DashboardNavGraph(navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        DashboardBottomBarScreen.Home,
        DashboardBottomBarScreen.Message,
        DashboardBottomBarScreen.Product,
        DashboardBottomBarScreen.ShoppingCart
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    BottomNavigation(
        modifier = Modifier
            .padding(5.dp)
            .graphicsLayer {
                shape = RoundedCornerShape(15.dp)
                clip = true
            }

    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: DashboardBottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
//        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        unselectedContentColor = Color.White,
        selectedContentColor = Color.Green,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}