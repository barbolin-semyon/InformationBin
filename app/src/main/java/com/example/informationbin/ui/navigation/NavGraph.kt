package com.example.informationbin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.informationbin.ui.features.BinInformationView
import com.example.informationbin.ui.features.InputBinView
import com.example.informationbin.ui.theme.Gray
import com.example.informationbin.ui.theme.Green
import com.google.accompanist.systemuicontroller.SystemUiController

@Composable
fun NavGraph(navController: NavHostController, ui: SystemUiController) {
    NavHost(navController = navController, startDestination = Screens.Information.route) {
        information(navController, ui)

        composable(route = Screens.History.route) {
            ui.setStatusBarColor(Gray)
        }
    }
}

fun NavGraphBuilder.information(navController: NavHostController, ui: SystemUiController) {
    navigation(
        route = Screens.Information.route,
        startDestination = InformationScreens.InputBin.route
    ) {
        composable(InformationScreens.InputBin.route) {
            ui.setStatusBarColor(Gray)
            InputBinView(navController)
        }

        composable (
            route = InformationScreens.DetailBin.route,
            arguments = listOf(navArgument("bin") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            ui.setStatusBarColor(Green)

            navBackStackEntry.arguments?.getString("bin")?.let { bin ->

            }
        }
    }
}