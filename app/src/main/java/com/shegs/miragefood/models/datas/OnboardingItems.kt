package com.shegs.miragefood.models.datas

import com.shegs.miragefood.R

sealed class OnboardingItems(val image: Int, val title: String, val description: String) {
    object First : OnboardingItems(
        image = R.drawable.onboarding_image_1,
        title = "Welcome to Mirage Lunch",
        description = "Celebrate achievements, big or small\n" +
                "with a ‘free lunch’ !",
    )

    object Second : OnboardingItems(
        image = R.drawable.onboarding_image_2,
        title = "Recognize and Reward",
        description = "Celebrate achievements, big or small\n" +
                "with a ‘free lunch’ !",
    )

    object Third : OnboardingItems(
        image = R.drawable.onboarding_image_3,
        title = "Encourage Productivity",
        description = "Encourage a positive work environment\n" +
                "with meaningful acknowledgements",
    )
}