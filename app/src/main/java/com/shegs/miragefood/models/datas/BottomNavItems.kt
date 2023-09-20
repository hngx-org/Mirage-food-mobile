package com.shegs.miragefood.models.datas

import com.shegs.miragefood.R

sealed class BottomNavItems(val label: String, val icon: Int, val route: String) {
    object Home : BottomNavItems("Home", R.drawable.icon_home, "home_screen")
    object Search : BottomNavItems("Search", R.drawable.icon_search, "search_screen")
    object Notifications :
        BottomNavItems("Notifications", R.drawable.icon_bell, "notifications_screen")

    object Settings : BottomNavItems("Settings", R.drawable.icon_setting, "settings_screen")

}
