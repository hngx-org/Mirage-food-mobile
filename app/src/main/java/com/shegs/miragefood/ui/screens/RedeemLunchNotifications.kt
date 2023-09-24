package com.shegs.miragefood.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shegs.miragefood.models.datas.RedeemLunchNotification
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.grey3
import com.shegs.miragefood.utils.CenterTextWithDivider
import com.shegs.miragefood.utils.RedeemLunchNotificationCard
import com.shegs.miragefood.utils.convertTimestampToTime
import com.shegs.miragefood.viewmodels.RedeemLunchNotificationsViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RedeemLunchNotifications(
    redeemLunchNotificationsViewModel: RedeemLunchNotificationsViewModel = hiltViewModel(),
    navController: NavController
) {
    val redeemLunchNotifications by redeemLunchNotificationsViewModel.redeemLunchNotificatinos.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CenterTextWithDivider(text = "Redeem Lunch")
        RedeemLunchLazyColumn(
            redeemLunchNotifications = redeemLunchNotifications,
            navController = navController
        )

    }

}

@Composable
fun RedeemLunchLazyColumn(
    redeemLunchNotifications: List<RedeemLunchNotification>,
    navController: NavController
) {
    val groupedNotifications =
        redeemLunchNotifications.groupBy { convertTimestampToTime(it.timeStamp) }

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
                        .padding(bottom = 28.dp)
                )
            }
            items(redeemLunchNotifications) { redeemLunchNotification ->
                RedeemLunchNotificationCard(
                    redeemLunchNotification = redeemLunchNotification,
                    navController
                )
            }
        }

    }
}
