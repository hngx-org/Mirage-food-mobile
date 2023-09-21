package com.shegs.miragefood.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shegs.miragefood.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.utils.TopNavigationBar

@Composable
fun WithdrawScreen() {
    var isSheetOpen by rememberSaveable{ mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .height(141.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Withdraw redeemed cash to your\n" +
                            "bank account",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                    )

                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "₦20,000",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    )
                Text(
                    text = "Redeemed Balance",
                    fontSize = 14.sp,
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Amount",
                fontSize = 14.sp
            )
            Text(
                text = "Reason (optional)",
                fontSize = 14.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ElevatedButton(
                onClick = { /* Handle button 1 click */ },
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = "₦20,000")
            }
            Spacer(modifier = Modifier.width(16.dp))
            ElevatedButton(
            onClick = { /* Handle button 1 click */ },
                modifier = Modifier
                    .weight(1f)


            ) {
                Text(
                    text = "Other",
                    color = Color(0x331E1E1E),
                )
            }
        }

        Text(
            text = "To",
            fontSize = 12.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight(400),

            )

        Spacer(modifier = Modifier.height(5.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(91.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.account_balance_fill),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Elizabeth Faith Yaroson")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "10110000 - KUDA MFB")
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(91.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.account_balance_fill),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Elizabeth Faith Yaroson")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "22058383 - Access Bank")
            }
        }

        Button(
            onClick = {
                //Todo() handle logic to open bottom sheet
                isSheetOpen = true
                      },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Withdraw")
        }
    }
    FullScreenBottomSheet(
        isSheetOpen, onDismissSheet = {
        isSheetOpen = false
    })
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FullScreenBottomSheet(isSheetOpen: Boolean, onDismissSheet: () -> Unit) {
    var amount by remember { mutableStateOf("2000") }
    val sheetState = rememberModalBottomSheetState()



    if(isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { onDismissSheet}
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.group_right),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.celebrate),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(shape = CircleShape)
                        .background(Color.Gray)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Congratulations!",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "₦$amount has been added to your\n" +
                            "wallet",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Have Fun",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.group_left),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = CircleShape)
                        .background(Color.Gray)
                )
            }
        }
    }

}


@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun MyUIPreview() {
        WithdrawScreen()
}
