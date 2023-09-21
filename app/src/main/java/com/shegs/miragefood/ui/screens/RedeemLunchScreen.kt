package com.shegs.miragefood.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shegs.miragefood.models.datas.ReceivedTransaction
import com.shegs.miragefood.utils.BottomSheet
import com.shegs.miragefood.utils.FreeLunchTitle
import com.shegs.miragefood.utils.TopNavigationBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LunchDetailsScreen(
    receivedTransaction: ReceivedTransaction,
    closeModal: () -> Unit,
) {
    var showModalBottomSheet by remember { mutableStateOf(false) } // Track if the bottom sheet should be shown

    val sheetState = androidx.compose.material3.rememberModalBottomSheetState()
    androidx.compose.material3.Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        topBar = {
            TopNavigationBar(
                onBackButtonPressed = {})
        }
    ) {
        BottomSheetScaffold(
            sheetContent = {
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
            },
            sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            sheetBackgroundColor = MaterialTheme.colorScheme.onPrimaryContainer,
            sheetElevation = 16.dp,
            scaffoldState = rememberBottomSheetScaffoldState(),
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 60.dp, start = 14.dp, end = 12.dp),

                ) {
                FreeLunchTitle(title = "Redeem Free Lunch")
                Text(text = "You were sent free lunch by")
                Text(
                    text = "${receivedTransaction.sender}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Amount")
                Text(
                    text = "${receivedTransaction.amountSent} free lunch",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Description")
                Text(
                    text = "Note: ${receivedTransaction.message}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Your Free Lunch redeemed for cash will be added to your wallet. 1 Free Lunch equates to ₦1,000"

                )


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            // Set the showModalBottomSheet flag to true to show the bottom sheet
                            showModalBottomSheet = true
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    ) {
                        Text(text = "Redeem Lunch")
                    }
                    Button(
                        onClick = {
                            // Close the screen and go back to homeScreen
                            closeModal()
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Close")
                    }
                }
            }
        }
    }
}

