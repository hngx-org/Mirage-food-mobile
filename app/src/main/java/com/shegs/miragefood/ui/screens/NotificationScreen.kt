package com.shegs.miragefood.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.shegs.miragefood.R
import com.shegs.miragefood.models.datas.ReceivedTransaction
import com.shegs.miragefood.models.datas.SentTransaction
import com.shegs.miragefood.models.datas.WithdrawnTransaction
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.utils.CenterTextWithDivider
import com.shegs.miragefood.utils.generateSampleTransactions


@Composable
fun NotificationScreen() {
    val transactions = generateSampleTransactions()

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        CenterTextWithDivider(text = "Redeem Lunch")
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 50.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(transactions) { transaction ->
                when (transaction) {
                    is SentTransaction -> SentTransactionItem(transaction)
                    is ReceivedTransaction -> ReceivedTransactionItem(transaction)
                    is WithdrawnTransaction -> WithdrawnTransactionItem(transaction)
                    else -> {}
                }
            }
        }
    }
}


@Composable
fun SentTransactionItem(transaction: SentTransaction) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
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
                text = "You're a good sport! \uD83D\uDE0A",
                style = Typography.bodySmall.copy(
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.scrim
                )
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.scrim.copy(0.7f))) {
                        append("Your Free lunch gift to ")
                    }
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary.copy(0.7f))) {
                        append("${transaction.receiver}")
                    }
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.scrim.copy(0.7f))) {
                        append(" was successful")
                    }
                },
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight(400),
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = transaction.timestamp.toString(),
                fontWeight = FontWeight(500),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.scrim.copy(0.7f)
            )
        }

    }
}

@Composable
fun ReceivedTransactionItem(transaction: ReceivedTransaction) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
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
                text = "Yay ! You've got something \uD83D\uDE0A",
                style = Typography.bodySmall.copy(
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.scrim
                )
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.scrim.copy(0.7f))) {
                        append("You received ")
                    }
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary.copy(0.7f))) {
                        append("${transaction.amountSent}")
                    }
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.scrim.copy(0.7f))) {
                        append(" Free Lunch from ${transaction.sender}")
                    }
                },
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight(400),
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = "'${transaction.message}'",
                fontWeight = FontWeight(500),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.scrim.copy(0.7f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = transaction.timestamp.toString(),
                fontWeight = FontWeight(500),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.scrim.copy(0.7f)
            )
        }

    }
}

@Composable
fun WithdrawnTransactionItem(transaction: WithdrawnTransaction) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
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
                text = "Withdrawal Successful",
                style = Typography.bodySmall.copy(
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.scrim
                )
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.scrim.copy(0.7f))) {
                        append("Your withdrawal of ")
                    }
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary.copy(0.7f))) {
                        append("${transaction.withdrawnAmount}")
                    }
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.scrim.copy(0.7f))) {
                        append(" was successful")
                    }
                },
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight(400),
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = transaction.timestamp.toString(),
                fontWeight = FontWeight(500),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.scrim.copy(0.7f)
            )
        }

    }
}


