package com.shegs.miragefood.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shegs.miragefood.R
import com.shegs.miragefood.models.datas.Lunch
import com.shegs.miragefood.navigations.NestedNavItem
import com.shegs.miragefood.ui.screens.common.SmallButton
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.grey3

@Composable
fun RedeemLunchNotificationCard(lunch: Lunch, navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_bell),
                contentDescription = "Lunch Icon",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(20.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "Yay! You've got something",
                style = Typography.bodyMedium.copy(
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp
                ),
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.scrim
                        )
                    ) {
                        append("You received ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        append("${lunch.quantity}")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.scrim
                        )
                    ) {
                        append(" Free Lunch from ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        append(lunch.sender_id)
                    }
                },
                fontWeight = FontWeight(400),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.scrim,
                modifier = Modifier
                    .alpha(0.6f)

            )
            Spacer(modifier = Modifier.height(12.dp))
            SmallButton(
                text = "Redeem Free Lunch",
                onClick = {navController.navigate(NestedNavItem.RedeemLunchScreen.route)}
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = lunch.created_at,
                style = Typography.bodyMedium.copy(
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp,
                    color = grey3
                ),
            )
        }

    }
}

//@Preview
//@Composable
//fun RedeemLunchNotificationPreview() {
//    RedeemLunchNotificationCard()
//}