package com.shegs.miragefood.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.shegs.miragefood.models.datas.UserData
import com.shegs.miragefood.viewmodels.UserViewModel

@Composable
fun HomeScreen(userViewModel: UserViewModel) {

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
                ActionButtonSection()
                RecentTransactionSection()
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
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "20 Free Lunch",
                fontWeight = FontWeight(500),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.scrim
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Redeemed Free Lunch",
                fontWeight = FontWeight(400),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.scrim,
                modifier = Modifier
                    .alpha(0.6f)
            )
        }

    }

}


@Composable
fun ActionButtonSection() {

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
                onClick = { /*TODO*/ },
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
                onClick = { /*TODO*/ },
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
                onClick = { /*TODO*/ },
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
fun RecentTransactionSection() {
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
                onClick = { },
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .alpha(0.6f)
            )
    }
}