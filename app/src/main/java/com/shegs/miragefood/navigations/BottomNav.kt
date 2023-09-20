package com.shegs.miragefood.navigations

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.shegs.miragefood.models.datas.BottomNavItems


@Composable
fun BottomNavBar(navController: NavController) {

    val navItems = listOf(
        BottomNavItems.Home,
        BottomNavItems.Search,
        BottomNavItems.Notifications,
        BottomNavItems.Settings
    )

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    // Only show the bottom nav bar when the current route is one of the bottom nav destinations
    val bottomBarDestination = navItems.any { it.route == currentRoute }

    if (bottomBarDestination) {
        NavigationBar {
            navItems.forEach { screen ->
                val selected = screen.route == currentRoute
                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        navController.navigate(screen.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route)
                            }
                            // Handles instances when the destination is already at the top of the stack.
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = screen.icon),
                            contentDescription = screen.label,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = {
                        Text(text = screen.label, style = MaterialTheme.typography.labelLarge)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                            LocalAbsoluteTonalElevation.current
                        )
                    )
                )
            }
        }
    }
}

