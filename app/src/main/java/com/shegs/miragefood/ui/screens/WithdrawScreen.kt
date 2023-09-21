package com.shegs.miragefood.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shegs.miragefood.models.datas.WithdrawnTransaction
import com.shegs.miragefood.ui.screens.common.BottomSheet
import com.shegs.miragefood.ui.screens.common.RoundedCornerButton
import com.shegs.miragefood.ui.screens.common.TopNavigationBar
import com.shegs.miragefood.ui.theme.seed

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun WithdrawScreen(
    withdrawnTransaction: WithdrawnTransaction,
    navController: NavController,
    closeModal: () -> Unit,
) {
    var isSheetOpen by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopNavigationBar(
                navController = navController,
                onBackButtonPressed = { TODO()/* Handle back button press */ }
            )
        }
    ) {
        BottomSheetScaffold(
            sheetContent = {
                if (isSheetOpen) {
                    BottomSheet(
                        sheetState = sheetState,
                        title = "Cheers!",
                        emojiUnicode = 0x1F911,
                        description = "Your funds have been successfully withdrawn",
                        secondDescription = "You are all set!"
                    ) {
                        // Close the bottom sheet when the "Close" button in the sheet is clicked
                        isSheetOpen = false
                    }
                }
            },
            sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            sheetBackgroundColor = MaterialTheme.colorScheme.onPrimaryContainer,
            sheetElevation = 16.dp,
            scaffoldState = rememberBottomSheetScaffoldState(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 72.dp)
                        .height(95.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Withdraw redeemed cash to your bank account",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF1E1E1E),
                        )

                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "20 free lunch",
                            fontSize = 20.sp,
                            fontWeight = FontWeight(500),
                        )
                        Text(
                            text = "Your free lunch redeemed balance",
                            fontSize = 14.sp,
                        )
                    }
                }

                TextRowWithTwoTexts(
                    text1 = "Free lunch amount",
                    text2 = "Redeemed Cash",
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth()
                )

                ButtonRow(
                    onClick1 = { /*TODO*/ },
                    text1 = "10",
                    onClick2 = { /*TODO*/ },
                    text2 = "₦20000"
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "To",
                    fontSize = 12.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(400),
                )

                TextRowWithTwoTexts(
                    text1 = "Bank Name",
                    text2 = "Account Name",
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth()
                )

                ButtonRow(
                    onClick1 = { /*TODO*/ },
                    text1 = "Kuda MFB",
                    onClick2 = { /*TODO*/ },
                    text2 = "1120000"
                )

                Spacer(modifier = Modifier.height(5.dp))

                TextRowWithTwoTexts(
                    text1 = "Account Name",
                    text2 = "Reason",
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth()
                )

                ButtonRow(
                    onClick1 = { /*TODO*/ },
                    text1 = "Peter Joe",
                    onClick2 = { /*TODO*/ },
                    text2 = "other"
                )
                RoundedCornerButton(text = "Withdraw") {
                    //Todo Handle logic to open sheet
                    isSheetOpen = true
                }
            }


        }

    }
}

@Composable
fun ButtonRow(
    onClick1: () -> Unit,
    text1: String,
    onClick2: () -> Unit,
    text2: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            modifier = Modifier
                .background(color = Color(0x1A967BB6), shape = RoundedCornerShape(size = 8.dp))
                .weight(1f)
                .clickable { onClick1() },
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text1,
                    style = MaterialTheme.typography.bodyMedium.copy(color = seed),
                    fontWeight = FontWeight(500),
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Card(
            modifier = Modifier
                .background(color = Color(0x1A967BB6), shape = RoundedCornerShape(size = 8.dp))
                .weight(1f)
                .clickable { onClick2() },
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text2,
                    style = MaterialTheme.typography.bodyMedium.copy(color = seed),
                    fontWeight = FontWeight(500),
                )
            }
        }
    }
}

@Composable
fun TextRowWithTwoTexts(
    text1: String,
    text2: String,
    fontSize: TextUnit = 14.sp,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text1,
            fontSize = fontSize,
        )
        Text(
            text = text2,
            fontSize = fontSize,
        )
    }
}
