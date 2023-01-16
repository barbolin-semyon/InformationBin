package com.example.informationbin.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.informationbin.ui.theme.DarkGray
import com.example.informationbin.ui.theme.Gray
import com.example.informationbin.ui.theme.Green

@Composable
fun AppBottomNavigation(navHostController: NavHostController) {
    val state by navHostController.currentBackStackEntryAsState()
    val route = state?.destination?.route

    BottomNavigation {
        screensForBottomNav.forEach { screen ->
            val selected =
                screen.route == route || ((route in infoRoutes) && (screen.route == Screens.Information.route))


            BottomNavigationItem(selected = selected, onClick = {
                navHostController.navigate(screen.route) {
                    launchSingleTop = true
                }
            }, icon = {
                Icon(
                    painter = painterResource(id = screen.icon),
                    contentDescription = screen.label
                )
            }, label = {
                Text(text = screen.label)
            }, selectedContentColor = Color.White, unselectedContentColor = DarkGray
            )
        }
    }
}