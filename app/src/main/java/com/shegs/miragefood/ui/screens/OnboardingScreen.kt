package com.shegs.miragefood.ui.screens

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shegs.miragefood.models.datas.OnboardingItems
import com.shegs.miragefood.navigations.NestedNavItem
import com.shegs.miragefood.ui.events.OnboardingEvent
import com.shegs.miragefood.ui.events.OnboardingUiEvent
import com.shegs.miragefood.ui.screens.common.RoundedCornerButton
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.utils.HorizontalPagerIndicator
import com.shegs.miragefood.viewmodels.OnboardingViewModel
import kotlinx.coroutines.flow.collectLatest


@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController,
    onboardingViewModel: OnboardingViewModel = hiltViewModel(),
    onEvent: (OnboardingEvent) -> Unit
) {

    val state = onboardingViewModel.state.collectAsState().value

    LaunchedEffect(key1 = true) {
        onboardingViewModel.onboardingEventFlow.collectLatest { event ->
            when (event) {
                OnboardingUiEvent.NavigateToSignIn -> {
                    navController.navigate(NestedNavItem.SignInScreen.route)
                }

                OnboardingUiEvent.NavigateToSignUp -> {
                    navController.navigate(NestedNavItem.SignUpScreen.route)
                }
            }
        }
    }


    val pagerState = rememberPagerState(pageCount = {
        onboardingViewModel.retrieveOnboardingPages().size
    })

    val pageIndex = onboardingViewModel.pageIndex.collectAsState()

    LaunchedEffect(pagerState) {
        val pagerStateFlow = pagerState.currentPage
        onboardingViewModel.observePageIndex(pagerStateFlow)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) {
            // onboardingViewModel.setIndex(index)
            Log.d("OnBoardingScreen", "Current Page: $it")

            PagerScreen(onboardingItems = onboardingViewModel.onboardingPages.value[it])
        }
        Spacer(modifier = Modifier.height(0.dp))
        HorizontalPagerIndicator(
            pageCount = onboardingViewModel.onboardingPages.value.size,
            pagerState = pagerState,
        )
        Spacer(modifier = Modifier.height(0.dp))
        RoundedCornerButton(
            text = "Sign Up",
            onClick = {
                onEvent(OnboardingEvent.OnSignUpClick)
            })

        Spacer(modifier = Modifier.height(10.dp))

        RoundedCornerButton(
            text = "Sign In",
            usePlainButton = true,
            onClick = {
                onEvent(OnboardingEvent.OnSignInClick)
            })

        Spacer(modifier = Modifier.height(60.dp))

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
        Spacer(modifier = Modifier.height(80.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
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
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            text = onboardingItems.description,
            style = Typography.bodySmall.copy(
                fontWeight = FontWeight.W400,
                color = Color(0x991E1E1E),
                fontSize = 16.sp,
                lineHeight = 24.sp
            )
        )
        Spacer(modifier = Modifier.height(40.dp))
    }
}





