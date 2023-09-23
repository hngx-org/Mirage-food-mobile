package com.shegs.miragefood.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shegs.miragefood.models.datas.Lunch
import com.shegs.miragefood.ui.states.GetAllLunchState
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.grey3
import com.shegs.miragefood.ui.theme.md_theme_light_error
import com.shegs.miragefood.utils.CenterTextWithDivider
import com.shegs.miragefood.utils.RedeemLunchNotificationCard
import com.shegs.miragefood.viewmodels.LunchViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RedeemLunchNotifications(lunchViewModel: LunchViewModel, navController: NavController) {
    val lunchState by lunchViewModel.lunchState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CenterTextWithDivider(text = "Redeem Lunch")
        when (lunchState) {
            is GetAllLunchState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is GetAllLunchState.Success -> {
                RedeemLunchLazyColumn(
                    lunch = (lunchState as GetAllLunchState.Success).lunch,
                    navController = navController
                )
            }

            is GetAllLunchState.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Error: ${(lunchState as GetAllLunchState.Error).detail}",
                        color = md_theme_light_error
                    )
                }

            }

            else -> {}
        }

    }

}

@Composable
fun RedeemLunchLazyColumn(lunch: List<Lunch>, navController: NavController) {
    val groupedNotifications =
        lunch.groupBy { it.createdAt }

    LazyColumn(
        modifier = Modifier.padding(top = 40.dp, start = 16.dp, end = 16.dp),
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
                        .padding(bottom = 28.dp)
                )
            }
            items(lunch) { lunch ->
                RedeemLunchNotificationCard(lunch = lunch, navController)
            }
        }

    }
}
