package com.shegs.miragefood.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreens(val label: String, val icon: ImageVector, val route: String) {
    object Home : BottomBarScreens("Home", Icons.Outlined.Home, "home_screen")
    object Search : BottomBarScreens("Search", Icons.Outlined.Search, "search_screen")
    object Notifications :
        BottomBarScreens("Notifications", Icons.Outlined.Notifications, "notifications_screen")

    object Settings : BottomBarScreens("Settings", Icons.Outlined.Settings, "settings_screen")

}