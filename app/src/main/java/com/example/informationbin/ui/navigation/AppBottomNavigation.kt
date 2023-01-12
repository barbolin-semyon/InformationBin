package com.example.informationbin.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.informationbin.ui.theme.Gray

@Composable
fun AppBottomNavigation(navHostController: NavHostController) {
    val state by navHostController.currentBackStackEntryAsState()
    val route = state?.destination?.route

    BottomNavigation {
        screensForBottomNav.forEach { screen ->
            BottomNavigationItem(
                selected = screen.route == route,
                onClick = {
                    navHostController.navigate(screen.route) {
                        popUpTo(navHostController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.route
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Gray
            )
        }
    }
}