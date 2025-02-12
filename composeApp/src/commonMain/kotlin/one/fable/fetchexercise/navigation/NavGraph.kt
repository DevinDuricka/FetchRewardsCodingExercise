package one.fable.fetchexercise.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import one.fable.fetchexercise.navigation.home.HomeScreen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController,
    startDestination: String = Screen.Home.route
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                //TODO - see parameters for example to navigate to new screen
                //navController.popBackStack()

            )
        }
//        composable(route = Screen.Details.route) {
//            DetailsScreen()
//        }
    }
}

