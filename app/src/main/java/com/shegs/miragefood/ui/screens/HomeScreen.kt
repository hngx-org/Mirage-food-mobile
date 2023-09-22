package com.shegs.miragefood.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shegs.miragefood.R
import com.shegs.miragefood.models.datas.ReceivedTransaction
import com.shegs.miragefood.models.datas.RedeemedTransaction
import com.shegs.miragefood.models.datas.Transaction
import com.shegs.miragefood.models.datas.UserData
import com.shegs.miragefood.models.datas.WithdrawnTransaction
import com.shegs.miragefood.navigations.NestedNavItem
import com.shegs.miragefood.ui.screens.common.LunchBalanceSection
import com.shegs.miragefood.viewmodels.TransactionViewModel
import com.shegs.miragefood.viewmodels.UserViewModel

@Composable
fun HomeScreen(userViewModel: UserViewModel, transactionViewModel: TransactionViewModel, navController: NavController) {

    val userData = userViewModel.userData.collectAsState().value

    userData?.let { user ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                UserGreeting(user)
                LunchBalance()
                ActionButtonSection(navController)
                RecentTransactionSection(navController)
                Spacer(modifier = Modifier.height(24.dp))
                TransactionScreen(transactionViewModel)
            }

        }
    }

}

@Composable
fun UserGreeting(user: UserData) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Column(
            modifier = Modifier
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Hi ${user.name} \uD83D\uDC4B",
                    fontWeight = FontWeight(500),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.scrim
                )

                Image(
                    painter = painterResource(user.img),
                    contentDescription = "User profile picture",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(36.dp)
                )
            }

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.scrim)) {
                        append("Send them that ")
                    }
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                        append("free lunch")
                    }
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.scrim)) {
                        append(" today!")
                    }
                },
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.scrim,
                fontWeight = FontWeight(400)
            )

        }
    }
}

@Composable
fun LunchBalance() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        LunchBalanceSection(
            lunchBalance = "20 Free Lunch",
            subtitle = "Redeemed Free Lunch"
        )
    }

}


@Composable
fun ActionButtonSection(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            val buttonModifier = Modifier
                .weight(1f) // Use weight to distribute the available space evenly
                .padding(8.dp)
                .border(1.dp, Color(0x80967BB6), shape = RoundedCornerShape(8.dp))
                .height(34.dp)

            Button(
                onClick = { navController.navigate(NestedNavItem.GiftLunchScreen.route) },
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x1A967BB6),
                    contentColor = Color(0xFF967BB6)
                ),
                modifier = buttonModifier
                    .width(84.dp)
            ) {
                Text(
                    text = "Gift Lunch",
                    fontWeight = FontWeight(500),
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1
                )
            }

            Button(
                onClick = {  },
                shape = RoundedCornerShape(8.dp),

                contentPadding = PaddingValues(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x1A967BB6),
                    contentColor = Color(0xFF967BB6)
                ),
                modifier = buttonModifier
                    .width(114.dp)
            ) {
                Text(
                    text = "Redeem Lunch",
                    fontWeight = FontWeight(500),
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1
                )
            }


            Button(
                onClick = { navController.navigate(NestedNavItem.WithdrawalScreen.route) },
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x1A967BB6),
                    contentColor = Color(0xFF967BB6)
                ),
                modifier = buttonModifier
                    .width(84.dp)
            ) {
                Text(
                    text = "Withdrawal",
                    fontWeight = FontWeight(500),
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1
                )
            }

        }

    }
}


@Composable
fun RecentTransactionSection(navController: NavController) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
            Text(
                text = "Recent",
                fontWeight = FontWeight(500),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.scrim
            )

            ClickableText(
                text = AnnotatedString("See all"),
                onClick = { navController.navigate(NestedNavItem.SeeAllNotification.route) },
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .alpha(0.6f)
            )
    }
}

@Composable
fun TransactionScreen(viewModel: TransactionViewModel) {
    // Observe the ViewModel data
    val transactions by viewModel.transactions.collectAsState(emptyList())

    // Display the data using the TransactionList Composable
    TransactionList(transactions = transactions)
}

@Composable
fun TransactionList(transactions: List<Transaction>) {
    LazyColumn {
        items(transactions) { transaction ->
            TransactionItem(transaction)
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    when (transaction) {
            is ReceivedTransaction -> ReceivedTransaction(transaction)
            is RedeemedTransaction -> RedeemedTransaction(transaction)
            is WithdrawnTransaction -> WithdrawnTransaction(transaction)
        else -> {}
    }
}



@Composable
fun ReceivedTransaction(transaction: ReceivedTransaction) {
    // Display received transaction content
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_lunch_notification),
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
                text = "From ${transaction.sender}",
                fontWeight = FontWeight(500),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.scrim
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = transaction.timestamp.toString(),
                fontWeight = FontWeight(400),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.scrim,
                modifier = Modifier
                    .alpha(0.6f)
            )
        }

        Text(
            text = "+${transaction.amountSent} Free Lunch",
            fontWeight = FontWeight(500),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary
        )

    }
}

@Composable
fun RedeemedTransaction(transaction: RedeemedTransaction) {
    // Display redeemed transaction content
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_redeemed),
                contentDescription = "Redeem Icon",
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
                text = "Redeemed Lunch",
                fontWeight = FontWeight(400),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.scrim
            )
            
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = transaction.timestamp.toString(),
                fontWeight = FontWeight(400),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.scrim,
                modifier = Modifier
                    .alpha(0.6f)
            )
        }

        Text(
            text = "${transaction.redeemedAmount} Free Lunch",
            fontWeight = FontWeight(500),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary
        )

    }
}

@Composable
fun WithdrawnTransaction(transaction: WithdrawnTransaction) {
    // Display withdrawn transaction content

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_withdraw),
                contentDescription = "Withdrawal Icon",
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
                text = "Withdrawal from Wallet",
                fontWeight = FontWeight(400),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.scrim
            )

            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = transaction.timestamp.toString(),
                fontWeight = FontWeight(400),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.scrim,
                modifier = Modifier
                    .alpha(0.6f)
            )
        }

        Text(
            text = "-${transaction.withdrawnAmount}",
            fontWeight = FontWeight(500),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.scrim
        )

    }
}