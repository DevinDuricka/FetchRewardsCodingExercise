package one.fable.fetchexercise.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Details : Screen("details")

}