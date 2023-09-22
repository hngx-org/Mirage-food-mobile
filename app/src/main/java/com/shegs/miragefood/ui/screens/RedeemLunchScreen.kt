package com.shegs.miragefood.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shegs.miragefood.models.datas.ReceivedTransaction
import com.shegs.miragefood.ui.screens.common.BottomSheet
import com.shegs.miragefood.ui.screens.common.HeaderTitle
import com.shegs.miragefood.ui.screens.common.TopNavigationBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RedeemLunchScreen(
    receivedTransaction: ReceivedTransaction,
    navController: NavController,
    closeModal: () -> Unit,
) {
    var showModalBottomSheet by remember { mutableStateOf(false) } // Track if the bottom sheet should be shown

    val sheetState = androidx.compose.material3.rememberModalBottomSheetState()

    androidx.compose.material3.Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopNavigationBar(
                navController = navController,
                onBackButtonPressed = {})
        }
    ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 60.dp, start = 14.dp, end = 14.dp),
                )
            {
                HeaderTitle(title = "Redeem Free Lunch")

                Text(
                    text = "\uD83C\uDF89",
                    fontSize = 72.sp,
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                )

                Text(
                    text = "You were sent free lunch by",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight(400),
                    color = MaterialTheme.colorScheme.scrim,
                    modifier = Modifier
                        .alpha(0.6f)
                )

                Text(
                    text = "${receivedTransaction.sender}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Amount",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight(400),
                    color = MaterialTheme.colorScheme.scrim,
                    modifier = Modifier
                        .alpha(0.6f)
                )

                Text(
                    text = "${receivedTransaction.amountSent} free lunch",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight(500),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Description",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight(400),
                    color = MaterialTheme.colorScheme.scrim,
                    modifier = Modifier
                        .alpha(0.6f)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 24.dp, horizontal = 16.dp)
                        ) {
                            androidx.compose.material3.Text(
                                text = "${receivedTransaction.message}",
                                style = MaterialTheme.typography.bodyMedium.copy(lineHeight = 27.sp),
                                fontWeight = FontWeight(500),
                                color = MaterialTheme.colorScheme.primary,
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            androidx.compose.material3.Text(
                                text = "\u2764",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.scrim.copy(0.6f))){
                            append("Your Free Lunch redeemed for cash will be added to your wallet.")
                        }
                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)){
                            append("1 Free Lunch equates to ₦1,000")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 38.dp, end = 38.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall

                )

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 35.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        onClick = {
                            // Set the showModalBottomSheet flag to true to show the bottom sheet
                            showModalBottomSheet = true
                        },
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(
                            text = "Redeem Lunch",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight(500),
                            color = MaterialTheme.colorScheme.onPrimary,
                        )
                    }

                    Spacer(modifier = Modifier.width(24.dp))

                    if (showModalBottomSheet) {
                        BottomSheet(
                            sheetState = sheetState,
                            title = "Congratulations!",
                            emojiUnicode = 0x1F601,
                            description = "You have redeemed your ${receivedTransaction.amountSent} free Lunch gift from ${receivedTransaction.sender}",
                            secondDescription = "Have fun!"
                        ) {
                            // Close the bottom sheet when the "Close" button in the sheet is clicked
                            showModalBottomSheet = false
                        }
                    }

                    Button(
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        onClick = {
                            // Close the screen and go back to homeScreen
                            closeModal()
                        },
                        modifier = Modifier
                            .weight(1f)

                    ) {
                        Text(
                            text = "Close",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight(500),
                            color = MaterialTheme.colorScheme.onPrimary,
                        )
                    }
                }
            }
    }
}

