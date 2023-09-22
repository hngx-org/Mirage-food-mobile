package com.shegs.miragefood.navigations

import com.shegs.miragefood.R

sealed class NestedNavItem(val route: String, val label: String? = null, val icon: Int? = null) {

    object SplashScreen : NestedNavItem(route = "splash_screen")

    object Onboarding : NestedNavItem(route = "onboarding_screen")

    object SignInScreen : NestedNavItem(route = "sign_in_screen")
    object SignUpScreen : NestedNavItem(route = "sign_up_screen")
    object SeeAllNotification : NestedNavItem(route = "see_all_notification")

    object GiftLunchScreen : NestedNavItem(route = "gift_lunch_screen")

    object WithdrawalScreen : NestedNavItem(route = "withdrawal_screen")

    object RedeemLunchScreen : NestedNavItem(route = "redeem_lunch_screen")

    object App : NestedNavItem(route = "app_screen") {
        object HomeScreen :
            NestedNavItem(route = "home_screen", label = "Home", icon = R.drawable.icon_home) {
        }

        object SearchScreen :
            NestedNavItem(route = "search_screen", label = "Search", icon = R.drawable.icon_search) {
        }

        object RedeemScreen : NestedNavItem(
            route = "redeem_screen",
            label = "Redeem",
            icon = R.drawable.icon_redeemed
        ) {

        }
    }
}
