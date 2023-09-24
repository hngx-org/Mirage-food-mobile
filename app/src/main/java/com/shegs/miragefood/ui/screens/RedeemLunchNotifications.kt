package com.shegs.miragefood.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shegs.miragefood.ui.states.GetAllLunchState
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.grey3
import com.shegs.miragefood.utils.CenterTextWithDivider
import com.shegs.miragefood.utils.RedeemLunchNotificationCard
import com.shegs.miragefood.viewmodels.LunchViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RedeemLunchNotifications(
    lunchViewModel: LunchViewModel,
    navController: NavController
) {
    val lunchState = lunchViewModel.lunchState.collectAsState().value

    val snackbarHostState = remember {
        androidx.compose.material3.SnackbarHostState()
    }

    val scope = rememberCoroutineScope()


    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) {

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CenterTextWithDivider(text = "Redeem Lunch")
        RedeemLunchLazyColumn(
            state = lunchState,
            navController = navController
        )
    }

}

@Composable
fun RedeemLunchLazyColumn(
    state: GetAllLunchState,
    navController: NavController
) {
    val groupedNotifications =
        state.lunch.groupBy { it.created_at }

    if (state.loading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, start = 16.dp, end = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            LazyColumn {
                item {
                    CircularProgressIndicator()
                }
                // Add other items here if needed
            }
        }
    }
    if (state.isLoaded && state.lunch.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LazyColumn {
                item {
                    Text(
                        text = "You don't have any lunch right now.",
                        style = Typography.bodyMedium.copy(
                            fontWeight = FontWeight.W500,
                            fontSize = 16.sp,
                            color = grey3
                        ),
                        modifier = Modifier
                            .padding(bottom = 32.dp)
                    )
                }
                // Add other items here if needed
            }
        }

    } else if (state.isLoaded && state.lunch.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier.padding(top = 100.dp, start = 16.dp, end = 16.dp),
        ) {
            groupedNotifications.forEach { (timestamp) ->
                // Display timestamp for each section

                item {
                    Text(
                        text = timestamp,
                        style = Typography.bodyMedium.copy(
                            fontWeight = FontWeight.W500,
                            fontSize = 16.sp,
                            color = grey3
                        ),
                        modifier = Modifier
                            .padding(bottom = 32.dp)
                    )
                }
                items(state.lunch) { lunch ->
                    RedeemLunchNotificationCard(lunch = lunch, navController)
                }
            }

        }
    }


}
