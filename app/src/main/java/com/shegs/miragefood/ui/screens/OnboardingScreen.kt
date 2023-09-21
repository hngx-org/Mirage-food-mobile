package com.shegs.miragefood.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.shegs.miragefood.models.datas.OnboardingItems
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.utils.HorizontalPagerIndicator
import com.shegs.miragefood.utils.RoundedCornerButton
import com.shegs.miragefood.viewmodels.OnboardingViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController,
    onboardingViewModel: OnboardingViewModel
) {


    val pagerState = rememberPagerState(pageCount = {
        onboardingViewModel.retrieveOnboardingPages().size
    })

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp)) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { index ->
            PagerScreen(onboardingItems = onboardingViewModel.onboardingPages[index])
        }
//        Spacer(modifier = Modifier.height(20.dp))
        HorizontalPagerIndicator(
            pageCount = onboardingViewModel.onboardingPages.size,
            pagerState = pagerState
        )
        Spacer(modifier = Modifier.height(40.dp))
        RoundedCornerButton(text = "Sign Up", onClick = {})
        Spacer(modifier = Modifier.height(24.dp))
        RoundedCornerButton(text = "Sign In", usePlainButton = true, onClick = {})
        Spacer(modifier = Modifier.height(123.49.dp))

    }


}


@Composable
fun PagerScreen(onboardingItems: OnboardingItems) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            painter = painterResource(id = onboardingItems.image),
            contentDescription = "Pager Image"
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
            text = onboardingItems.title,
            style = Typography.titleLarge.copy(fontWeight = FontWeight.W500, lineHeight = 36.sp)
        )

        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
            text = onboardingItems.description,
            style = Typography.bodySmall.copy(
                fontWeight = FontWeight.W400,
                color = Color(0x991E1E1E),
                fontSize = 16.sp,
                lineHeight = 24.sp
            )
        )
    }
}

@Preview
@Composable
@Preview(showBackground = true)
fun OnboardingScreenPreview() {
    val navController = rememberNavController()
    val viewModel = viewModel<OnboardingViewModel>()
    OnBoardingScreen(navController = navController, onboardingViewModel = viewModel)
}




