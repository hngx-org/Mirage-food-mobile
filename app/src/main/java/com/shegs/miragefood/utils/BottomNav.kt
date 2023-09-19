package com.shegs.miragefood.utils

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavBar(navController: NavController) {

    val screens = listOf(
        BottomBarScreens.Home,
        BottomBarScreens.Search,
        BottomBarScreens.Notifications,
        BottomBarScreens.Settings
    )

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    // Only show the bottom nav bar when the current route is one of the bottom nav destinations
    val bottomBarDestination = screens.any { it.route == currentRoute }

    if (bottomBarDestination) {
        NavigationBar {
            screens.forEach { screen ->
                val selected = screen.route == currentRoute
                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        navController.navigate(screen.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route)
                            }
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(imageVector = screen.icon, contentDescription = screen.label)
                    },
                    label = {
                        Text(text = screen.label)
                    }
                )
            }
        }
    }
}