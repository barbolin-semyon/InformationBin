package com.example.informationbin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Information.route) {
        information(navController)

        composable(route = Screens.History.route) {

        }
    }
}

fun NavGraphBuilder.information(navController: NavHostController) {
    navigation(
        route = Screens.Information.route,
        startDestination = InformationScreens.InputBin.route
    ) {
        composable(InformationScreens.InputBin.route) {

        }

        composable (
            route = InformationScreens.DetailBin.route,
            arguments = listOf(navArgument("bin") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString("bin")?.let { bin ->

            }
        }
    }
}