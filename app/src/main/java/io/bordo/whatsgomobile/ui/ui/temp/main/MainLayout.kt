package io.bordo.whatsgomobile.ui.ui.temp.main

//
//@Composable
//fun MainLayout(
//    viewModel: WhatsGOMobileViewModel
//) {
//    val navController = rememberNavController()
//    val coroutineScope = rememberCoroutineScope()
//
////    val leagues by viewModel.leagues.collectAsState()
//
//    coroutineScope.launch {
//        // TEMP to set a particular league until settings screen added
//        //viewModel.updateLeagues(listOf(""))
//    }

//    Scaffold(
//        bottomBar = { WhatsGOMobileBottomNavigation(navController, leagues) }
//    ) {
//        NavHost(
//            navController,
//            startDestination = Screen.LoginMainScreen.route,
//            modifier = Modifier.padding(it)
//        ) {
//            composable(route = Screen.LoginMainScreen.route) {
//                LoginPage(
//                    onLoginClick = {
//
//                    },
//                    onForgetClick = {
//
//                    }
//                )
//            }
//        }
//    }
//}

//fun NavGraphBuilder.loginGraph() {
//    navigation(
//        route = WGGraph.AUTHENTICATION,
//        startDestination = Screen.LoginMainScreen.route
//    ) {
//        composable(route = Screen.LoginMainScreen.route) {
//            LoginMainScreen(
//                onLoginClick = {
//
//                },
//                onForgetClick = {
//
//                }
//            )
//        }
//    }
//}