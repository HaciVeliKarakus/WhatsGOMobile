package io.bordo.whatsgomobile.ui.navigation

sealed class Screen(val route: String) {

    // login screens
    object LoginMainScreen : Screen(route = "LoginMainScreen")

    // palyer screens
    object PlayerListScreen : Screen(route = "PlayerListScreen")
    object PlayerDetailsScreen : Screen(route = "PlayerDetailsScreen")

    // fixture screens
    object FixtureListScreen : Screen(route = "FixtureListScreen")
    object FixtureDetailsScreen : Screen(route = "FixtureDetailsScreen")

    object LeagueStandingsListScreen : Screen(route = "LeagueStandingsListScreen")

    object MessageDetailScreen : Screen(route = "MessageDetailScreen")
}

object WGGraph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val MESSAGE = "message_graph"
    const val DASHBOARD = "dashboard_graph"

}
