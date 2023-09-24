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
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shegs.miragefood.ui.screens.common.AppTextField
import com.shegs.miragefood.ui.screens.common.BottomSheet
import com.shegs.miragefood.ui.screens.common.HeaderTitle
import com.shegs.miragefood.ui.screens.common.LunchBalanceSection
import com.shegs.miragefood.ui.screens.common.RoundedCornerButton
import com.shegs.miragefood.ui.screens.common.TextFieldHeader
import com.shegs.miragefood.ui.screens.common.TopNavigationBar
import com.shegs.miragefood.ui.theme.seed
import com.shegs.miragefood.viewmodels.WithdrawalViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun WithdrawScreen(
    navController: NavController,
    withdrawalViewModel: WithdrawalViewModel = hiltViewModel()
) {

    var showModalBottomSheet = withdrawalViewModel.showBottomSheet.collectAsState()
    val sheetState = rememberModalBottomSheetState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopNavigationBar(
                navController = navController,
                onBackButtonPressed = { TODO()/* Handle back button press */ }
            )
        }
    ) {
            var lunchAmount by remember { mutableStateOf("") }
            var cashEquivalent by remember { mutableStateOf("") }
            var bankName by remember { mutableStateOf("") }
            var accountNumber by remember { mutableStateOf("") }
            var accountName by remember { mutableStateOf("") }
            var reason by remember { mutableStateOf("") }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 60.dp, start = 20.dp, end = 20.dp),
            )
            {
                HeaderTitle(
                    title = "Withdraw to Bank account",
                    subtitle = "Withdraw redeemed cash to your bank account"
                )

                Spacer(modifier = Modifier.height(32.dp))

                LunchBalanceSection(
                    lunchBalance = "20 Free Lunch",
                    subtitle = "Withdraw redeemed cash to your bank account"
                )

                Spacer(modifier = Modifier.height(45.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        TextFieldHeader(header = "Free Lunch Amount")
                        Spacer(modifier = Modifier.height(6.dp))
                        AppTextField(
                            placeholderComposable = null,
                            containerColor = MaterialTheme.colorScheme.primary.copy(0.1f),
                            placeholderColor = seed,
                            value = lunchAmount,
                            placeholder = "10",
                            onValueChanged = {
                                if (it != null) {
                                    lunchAmount = it
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(22.dp))
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        TextFieldHeader(header = "Cash Equivalent")
                        Spacer(modifier = Modifier.height(6.dp))
                        AppTextField(
                            containerColor = MaterialTheme.colorScheme.primary.copy(0.1f),
                            value = cashEquivalent,
                            placeholder = "#10,000",
                            onValueChanged = {
                                if (it != null) {
                                    cashEquivalent = it
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "To",
                    fontSize = 12.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(400),
                )

                Spacer(modifier = Modifier.height(24.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        TextFieldHeader(header = "Bank Name")
                        Spacer(modifier = Modifier.height(6.dp))
                        AppTextField(
                            placeholderComposable = null,
                            containerColor = MaterialTheme.colorScheme.primary.copy(0.1f),
                            placeholderColor = seed,
                            value = bankName,
                            placeholder = "KUDA MFB",
                            onValueChanged = {
                                if (it != null) {
                                    bankName = it
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(22.dp))
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        TextFieldHeader(header = "Account Number")
                        Spacer(modifier = Modifier.height(6.dp))
                        AppTextField(
                            containerColor = MaterialTheme.colorScheme.primary.copy(0.1f),
                            value = accountNumber,
                            placeholder = "2015101274",
                            onValueChanged = {
                                if (it != null) {
                                    accountNumber = it
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        TextFieldHeader(header = "Account Name")
                        Spacer(modifier = Modifier.height(6.dp))
                        AppTextField(
                            placeholderComposable = null,
                            containerColor = MaterialTheme.colorScheme.primary.copy(0.1f),
                            placeholderColor = seed,
                            value = accountName,
                            placeholder = "Peter Joe",
                            onValueChanged = {
                                if (it != null) {
                                    accountName = it
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(22.dp))
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        TextFieldHeader(header = "Reason (optional)")
                        Spacer(modifier = Modifier.height(6.dp))
                        AppTextField(
                            containerColor = MaterialTheme.colorScheme.primary.copy(0.1f),
                            value = reason,
                            placeholder = "other",
                            onValueChanged = {
                                if (it != null) {
                                    reason = it
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                    if (showModalBottomSheet.value) {
                        BottomSheet(
                            sheetState = sheetState,
                            title = "Cheers!",
                            emojiUnicode = 0x1F911,
                            description = "Your funds have been successfully withdrawn",
                            secondDescription = "You are all set!"
                        ) {
                            withdrawalViewModel.setShowBottomSheet(showBottomSheet = false)
                        }
                    }

                RoundedCornerButton(text = "Withdraw", onClick = {
                    withdrawalViewModel.setShowBottomSheet(true)
                })
            }

    }
}