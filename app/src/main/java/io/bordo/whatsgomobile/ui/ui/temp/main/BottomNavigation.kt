package io.bordo.whatsgomobile.ui.ui.temp.main


//@Composable
//fun WhatsGOMobileBottomNavigation(
//    navController: NavHostController,
//    leagues: List<String>
//) {
//
//    BottomNavigation {
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry?.destination?.route
//
//        bottomNavigationItems.forEach { bottomNavigationitem ->
//
//            val skipItem = bottomNavigationitem.route == Screen.LeagueStandingsListScreen.route
//                    && leagues.isEmpty()
//
//            if (!skipItem) {
//                BottomNavigationItem(
//                    icon = {
//                        Icon(
//                            bottomNavigationitem.icon,
//                            contentDescription = bottomNavigationitem.iconContentDescription
//                        )
//                    },
//                    selected = currentRoute == bottomNavigationitem.route,
//                    onClick = {
//                        navController.navigate(bottomNavigationitem.route) {
//                            popUpTo(navController.graph.id)
//                            launchSingleTop = true
//                        }
//                    }
//                )
//            }
//        }
//    }
//
//}