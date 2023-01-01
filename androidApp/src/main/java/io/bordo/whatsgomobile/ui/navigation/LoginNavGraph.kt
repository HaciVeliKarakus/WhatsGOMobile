package io.bordo.whatsgomobile.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import io.bordo.whatsgomobile.ui.screen.login.LoginPage
import io.bordo.whatsgomobile.ui.screen.login.MailConfirm
import io.bordo.whatsgomobile.ui.screen.login.PasswordConfirm
import io.bordo.whatsgomobile.ui.screen.login.Successful

fun NavGraphBuilder.loginNavGraph(navController: NavHostController) {
    navigation(
        route = WGGraph.AUTHENTICATION,
        startDestination = LoginScreens.Login.route
    ) {
        composable(route = LoginScreens.Login.route) {
            LoginPage(
                onLoginClick = {
                    navController.popBackStack()
                    navController.navigate(WGGraph.DASHBOARD)
                },
                onForgetClick = {
                    navController.navigate(LoginScreens.MailConfirm.route)
                }
            )
        }
        composable(route = LoginScreens.MailConfirm.route) {
            MailConfirm(
                onBackClick = {
                    navController.popBackStack()
                },
                onConfirmClick = {
                    navController.navigate(LoginScreens.PasswordConfirm.route)
                }
            )
        }
        composable(route = LoginScreens.PasswordConfirm.route) {
            PasswordConfirm(
                onBackClick = {
                    navController.popBackStack()
                },
                onConfirmClick = {
                    navController.navigate(LoginScreens.Successful.route)
                }
            )
        }
        composable(route = LoginScreens.Successful.route) {
            Successful(
                onClickSuccess = {
                    navController.popBackStack()
                    navController.navigate(WGGraph.DASHBOARD)
                }
            )
        }
    }
}


sealed class LoginScreens(val route: String) {
    object Login : LoginScreens("login_screen")
    object MailConfirm : LoginScreens("forget_password_mail")
    object PasswordConfirm : LoginScreens("password_confirm")
    object Successful : LoginScreens("successful")
}